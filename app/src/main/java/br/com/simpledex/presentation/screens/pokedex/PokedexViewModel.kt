package br.com.simpledex.presentation.screens.pokedex

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.simpledex.commom.extension.containsIgnoringAccent
import br.com.simpledex.domain.use_case.pokemon.GetNationalDexUseCase
import br.com.simpledex.domain.use_case.pokemon.GetPokemonByNameUseCase
import br.com.simpledex.domain.use_case.pokemon.GetPokemonFromLocalUseCase
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexEvents
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexUI
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PokedexViewModel(
    private val getNationalDexUseCase: GetNationalDexUseCase,
    private val getPokemonByNameUseCase: GetPokemonByNameUseCase,
    private val getPokemonFromLocalUseCase: GetPokemonFromLocalUseCase
) : ViewModel() {

    private val _homeUI = mutableStateOf(PokedexUI())
    val homeUI: State<PokedexUI> = _homeUI

    private val _pokemonListResponse = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val pokemonListResponse: StateFlow<StateUI<Unit>> = _pokemonListResponse

    private val _loadMoreResponse = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val loadMoreResponse: StateFlow<StateUI<Unit>> = _loadMoreResponse

    init {
        setupPokemonList()
    }

    fun onEvent(event: PokedexEvents) {
        when (event) {
            is PokedexEvents.CloseSearchBar -> {
                _homeUI.value = homeUI.value.copy(
                    isSearching = false,
                    searchText = ""
                )
                filter()
            }
            is PokedexEvents.OpenSearchBar -> {
                _homeUI.value = homeUI.value.copy(
                    isSearching = true
                )
            }
            is PokedexEvents.SearchTextChanged -> {
                _homeUI.value = homeUI.value.copy(
                    searchText = event.text
                )
                filter()
            }
        }
    }

    private fun setupPokemonList() {
        viewModelScope.launch {
            getPokemonFromLocalUseCase().onStart {
                _pokemonListResponse.emit(StateUI.Processing())
            }.catch {
                _pokemonListResponse.emit(StateUI.Error(it.message.orEmpty()))
            }.collect {
                _homeUI.value = homeUI.value.copy(pokemonList = it, filteredPokemonList = it)
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

    private fun pokemonListSize() = _homeUI.value.pokemonList.size

    fun loadMorePokemon() {
        if (_homeUI.value.isSearching.not()) {
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
    }

    private fun filter() {
        homeUI.value.apply {
            _homeUI.value = copy(
                filteredPokemonList = pokemonList
                    .filter { filterByName(it.name.orEmpty()) }
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