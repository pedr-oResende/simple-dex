package br.com.simpledex.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.simpledex.commom.extension.containsIgnoringAccent
import br.com.simpledex.domain.use_case.GetNationalDexUseCase
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.home.ui.HomeEvents
import br.com.simpledex.presentation.screens.home.ui.HomeUI
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getNationalDexUseCase: GetNationalDexUseCase
) : ViewModel() {

    private val _homeUI = mutableStateOf(HomeUI())
    val homeUI: State<HomeUI> = _homeUI
    
    private val _pokemonListResponse = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val pokemonListResponse: StateFlow<StateUI<Unit>> = _pokemonListResponse

    init {
        loadPokemonList()
    }

    fun onEvent(event: HomeEvents) {
        when (event) {
            is HomeEvents.CloseSearchBar -> {
                _homeUI.value = homeUI.value.copy(
                    isSearching = false,
                    searchText = ""
                )
                filter()
            }
            is HomeEvents.OpenSearchBar -> {
                _homeUI.value = homeUI.value.copy(
                    isSearching = true
                )
            }
            is HomeEvents.SearchTextChanged -> {
                _homeUI.value = homeUI.value.copy(
                    searchText = event.text
                )
                filter()
            }
        }
    }

    private fun loadPokemonList() {
        viewModelScope.launch {
            getNationalDexUseCase().onStart {
                _pokemonListResponse.emit(StateUI.Processing())
            }.catch {
                _pokemonListResponse.emit(StateUI.Error(it.message.orEmpty()))
            }.collect {
                _homeUI.value = homeUI.value.copy(
                    pokemonList = it,
                    filteredPokemonList = it.results
                )
                _pokemonListResponse.emit(StateUI.Processed())
            }
        }
    }

    fun refresh() = loadPokemonList()

    private fun filter() {
        homeUI.value.apply {
            _homeUI.value = copy(
                filteredPokemonList = pokemonList.results
                    .filter { filterByName(searchText) }
            )
        }
    }

    private fun filterByName(name: String) = _homeUI.value.run {
        if (searchText.isNotBlank()) {
            name.containsIgnoringAccent(searchText, ignoreCase = true)
        } else {
            true
        }
    }

}