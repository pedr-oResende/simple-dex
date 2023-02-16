package br.com.simpledex.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.simpledex.commom.extension.containsIgnoringAccent
import br.com.simpledex.domain.use_case.GetNationalDexUseCase
import br.com.simpledex.domain.use_case.GetPokemonByNameUseCase
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.home.ui.HomeEvents
import br.com.simpledex.presentation.screens.home.ui.HomeUI
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getNationalDexUseCase: GetNationalDexUseCase,
    private val getPokemonByNameUseCase: GetPokemonByNameUseCase
) : ViewModel() {

    private val _homeUI = mutableStateOf(HomeUI())
    val homeUI: State<HomeUI> = _homeUI

    private val _pokemonListResponse = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val pokemonListResponse: StateFlow<StateUI<Unit>> = _pokemonListResponse

    private val _loadMoreResponse = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val loadMoreResponse: StateFlow<StateUI<Unit>> = _loadMoreResponse

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
            getNationalDexUseCase(offset = 0).onStart {
                _pokemonListResponse.emit(StateUI.Processing())
            }.catch {
                _pokemonListResponse.emit(StateUI.Error(it.message.orEmpty()))
            }.collect {
                it.results.forEach { pokemon ->
                    loadPokemon(pokemon.name.orEmpty())
                }
                orderPokemonList()
                _pokemonListResponse.emit(StateUI.Processed())
            }
        }
    }

    private suspend fun loadPokemon(name: String) {
        getPokemonByNameUseCase(name).collect { pokemon ->
            homeUI.value.apply {
                _homeUI.value = copy(
                    pokemonList = pokemonList.plus(pokemon),
                    filteredPokemonList = pokemonList.plus(pokemon)
                )
            }
        }
    }

    private fun orderPokemonList() {
        homeUI.value.apply {
            val list = pokemonList.sortedBy { it.id }.distinct()
            _homeUI.value = copy(
                pokemonList = list,
                filteredPokemonList = list
            )
        }
    }

    fun pokemonListSize() = _homeUI.value.pokemonList.size

    fun loadMorePokemon() {
        viewModelScope.launch {
            getNationalDexUseCase(offset = pokemonListSize()).onStart {
                _loadMoreResponse.emit(StateUI.Processing())
            }.catch {
                _loadMoreResponse.emit(StateUI.Error(it.message.orEmpty()))
            }.collect {
                it.results.forEach { pokemon ->
                    loadPokemon(pokemon.name.orEmpty())
                }
                orderPokemonList()
                _loadMoreResponse.emit(StateUI.Processed())
            }
        }
    }

    private fun filter() {
        homeUI.value.apply {
            _homeUI.value = copy(
                filteredPokemonList = pokemonList
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