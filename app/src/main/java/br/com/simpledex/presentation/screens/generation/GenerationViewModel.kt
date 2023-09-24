package br.com.simpledex.presentation.screens.generation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.simpledex.commom.extension.*
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.use_case.generation.GetGenerationUseCase
import br.com.simpledex.domain.use_case.pokemon.*
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.generation.ui.GenerationEvents
import br.com.simpledex.presentation.screens.generation.ui.GenerationUI
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class GenerationViewModel(
    private val getGenerationUseCase: GetGenerationUseCase,
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase,
    name: String
) : ViewModel() {

    private val _pokedexUI = mutableStateOf(GenerationUI())
    val generationUI: State<GenerationUI> = _pokedexUI

    private val _pokemonListResponse = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val pokemonListResponse: StateFlow<StateUI<Unit>> = _pokemonListResponse

    private val _loadMoreState = MutableStateFlow<StateUI<Unit>>(StateUI.Idle())
    val loadMoreState: StateFlow<StateUI<Unit>> = _loadMoreState

    init {
        loadPokedex(name)
    }

    fun onEvent(event: GenerationEvents) {
        when (event) {
            is GenerationEvents.SearchTextChanged -> {
                _pokedexUI.value = generationUI.value.copy(
                    searchText = event.text
                )
                filter()
            }
        }
    }

    private fun loadPokedex(name: String) {
        viewModelScope.launch {
            getGenerationUseCase(name).onStart {
                _pokemonListResponse.emit(StateUI.Processing())
            }.catch {
                _pokemonListResponse.emit(StateUI.Error(it.message.orEmpty()))
            }.collect {
                _pokedexUI.value = generationUI.value.copy(generation = it)
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
        val reachLimit = _pokedexUI.value.generation.pokemonSpecies.size == _pokedexUI.value.pokemonList.size
        if (_pokedexUI.value.searchText.isBlank() && reachLimit.not()) {
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
        val limit = if (_pokedexUI.value.generation.pokemonSpecies.size.minus(offset).orZero() < 10) {
            _pokedexUI.value.generation.pokemonSpecies.size.minus(offset).orZero()
        } else {
            10
        }
        val subList =
            _pokedexUI.value.generation.pokemonSpecies.subList(offset, offset + limit)
        val loadedPokemons = mutableListOf<Pokemon>()
        subList.map { it.url }.forEach { url ->
            getPokemonByIdUseCase(id = url.idFromUrl()).collect { pokemon ->
                loadedPokemons.add(pokemon)
            }
            if (url == subList.last().url) {
                _pokedexUI.value = generationUI.value.copy(
                    pokemonList = generationUI.value.pokemonList.plus(loadedPokemons),
                    filteredPokemonList = generationUI.value.pokemonList.plus(loadedPokemons)
                )
                onSuccess()
            }
        }
    }

    fun isAllPokemonsLoaded(): Boolean {
        return (_pokedexUI.value.generation.pokemonSpecies.size) == (_pokedexUI.value.pokemonList.size)
    }

    private fun filter() {
        generationUI.value.apply {
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