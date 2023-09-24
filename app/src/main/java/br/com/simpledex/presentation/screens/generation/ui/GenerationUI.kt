package br.com.simpledex.presentation.screens.generation.ui

import br.com.simpledex.domain.model.generation.Generation
import br.com.simpledex.domain.model.pokedex.Pokedex
import br.com.simpledex.domain.model.pokemon.Pokemon

data class GenerationUI(
    val generation: Generation = Generation(),
    val pokemonList: List<Pokemon> = emptyList(),
    val filteredPokemonList: List<Pokemon> = emptyList(),
    val searchText: String = ""
)