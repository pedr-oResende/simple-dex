package br.com.simpledex.presentation.screens.pokedex

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.simpledex.commom.extension.containsIgnoringAccent
import br.com.simpledex.domain.use_case.pokemon.GetPokedexUseCase
import br.com.simpledex.domain.use_case.pokemon.GetPokemonByNameUseCase
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexEvents
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexUI
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PokedexViewModel(
    private val getNationalDexUseCase: GetPokedexUseCase,
    private val getPokemonByNameUseCase: GetPokemonByNameUseCase
) : ViewModel() {

    private val _pokedexUI = mutableStateOf(PokedexUI())
    val pokedexUI: State<PokedexUI> = _pokedexUI

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
                _pokedexUI.value = pokedexUI.value.copy(
                    isSearching = false,
                    searchText = ""
                )
                filter()
            }
            is PokedexEvents.OpenSearchBar -> {
                _pokedexUI.value = pokedexUI.value.copy(
                    isSearching = true
                )
            }
            is PokedexEvents.SearchTextChanged -> {
                _pokedexUI.value = pokedexUI.value.copy(
                    searchText = event.text
                )
                filter()
            }
        }
    }

    private fun setupPokemonList() {
        viewModelScope.launch {
            getNationalDexUseCase().onStart {
                _pokemonListResponse.emit(StateUI.Processing())
            }.catch {
                _pokemonListResponse.emit(StateUI.Error(it.message.orEmpty()))
            }.collect {
                _pokedexUI.value = pokedexUI.value.copy(pokemonList = it, filteredPokemonList = it)
                orderPokemonList()
                _pokemonListResponse.emit(StateUI.Processed(Unit))
            }
        }
    }

    private suspend fun loadPokemon(name: String) {
        getPokemonByNameUseCase(name).collect { pokemon ->
            pokedexUI.value.apply {
                _pokedexUI.value = copy(
                    pokemonList = pokemonList.plus(pokemon),
                    filteredPokemonList = pokemonList.plus(pokemon)
                )
            }
        }
    }

    private fun orderPokemonList() {
        pokedexUI.value.apply {
            val list = pokemonList.sortedBy { it.id }.distinct()
            _pokedexUI.value = copy(
                pokemonList = list,
                filteredPokemonList = list
            )
        }
    }

    private fun pokemonListSize() = _pokedexUI.value.pokemonList.size

    fun loadMorePokemon() {
        if (_pokedexUI.value.isSearching.not()) {
            viewModelScope.launch {
                getNationalDexUseCase(offset = pokemonListSize()).onStart {
                    _loadMoreResponse.emit(StateUI.Processing())
                }.catch {
                    _loadMoreResponse.emit(StateUI.Error(it.message.orEmpty()))
                }.collect {
                    it.results.forEach { pokemon ->
                        loadPokemon(pokemon.name)
                    }
                    orderPokemonList()
                    _loadMoreResponse.emit(StateUI.Processed(Unit))
                }
            }
        }
    }

    private fun filter() {
        pokedexUI.value.apply {
            _pokedexUI.value = copy(
                filteredPokemonList = pokemonList
                    .filter { filterByName(it.name.orEmpty()) }
            )
        }
    }

    private fun filterByName(name: String) = _pokedexUI.value.run {
        if (searchText.isNotBlank()) {
            name.containsIgnoringAccent(searchText, ignoreCase = true)
        } else {
            true
        }
    }

}