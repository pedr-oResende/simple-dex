package br.com.simpledex.presentation.screens.pokedex

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.simpledex.commom.extension.containsIgnoringAccent
import br.com.simpledex.commom.extension.idFromUrl
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.use_case.pokemon.*
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexEvents
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexUI
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PokedexViewModel(
    private val getPokedexUseCase: GetPokedexUseCase,
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase,
    id: Int
) : ViewModel() {

    private val _pokedexUI = mutableStateOf(PokedexUI())
    val pokedexUI: State<PokedexUI> = _pokedexUI

    private val _pokemonListResponse = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val pokemonListResponse: StateFlow<StateUI<Unit>> = _pokemonListResponse

    private val _loadMoreState = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val loadMoreState: StateFlow<StateUI<Unit>> = _loadMoreState

    init {
        loadPokedex(id)
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

    private fun loadPokedex(id: Int) {
        viewModelScope.launch {
            getPokedexUseCase(id).onStart {
                _pokemonListResponse.emit(StateUI.Processing())
            }.catch {
                _pokemonListResponse.emit(StateUI.Error(it.message.orEmpty()))
            }.collect {
                _pokedexUI.value = pokedexUI.value.copy(pokedex = it)
                setupFirstPokemons()
            }
        }
    }

    private suspend fun setupFirstPokemons() {
        setupPokemons(
            offset = 0,
            onSuccess = {
                _pokemonListResponse.emit(StateUI.Processed(Unit))
            }
        )
    }

    fun loadMorePokemon() {
        val reachLimit = _pokedexUI.value.pokedex?.pokemonEntries?.size == _pokedexUI.value.pokemonList.size
        if (_pokedexUI.value.isSearching.not() && reachLimit.not()) {
            viewModelScope.launch {
                _loadMoreState.emit(StateUI.Processing())
                setupPokemons(
                    offset = _pokedexUI.value.pokemonList.size,
                    onSuccess = {
                        _loadMoreState.emit(StateUI.Processed(Unit))
                    }
                )
            }
        }
    }

    private suspend fun setupPokemons(offset: Int, onSuccess: suspend () -> Unit) {
        val limit = if ((_pokedexUI.value.pokedex?.pokemonEntries?.size?.minus(offset) ?: 0) < 10) {
            _pokedexUI.value.pokedex?.pokemonEntries?.size?.minus(offset) ?: 0
        } else {
            10
        }
        val subList =
            _pokedexUI.value.pokedex?.pokemonEntries?.subList(offset, offset + limit) ?: emptyList()
        val loadedPokemons = mutableListOf<Pokemon>()
        subList.forEach { pokedexEntry ->
            getPokemonByIdUseCase(id = pokedexEntry.pokemon?.url?.idFromUrl() ?: 0).collect { pokemon ->
                loadedPokemons.add(pokemon)
            }
            if (pokedexEntry == subList.last()) {
                _pokedexUI.value = pokedexUI.value.copy(
                    pokemonList = pokedexUI.value.pokemonList.plus(loadedPokemons),
                    filteredPokemonList = pokedexUI.value.pokemonList.plus(loadedPokemons)
                )
                onSuccess()
            }
        }
    }

    fun isAllPokemonsLoaded(): Boolean {
        return (_pokedexUI.value.pokedex?.pokemonEntries?.size ?: 0) == (_pokedexUI.value.pokemonList.size)
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