package br.com.simpledex.presentation.screens.pokedex.ui

import br.com.simpledex.domain.model.pokedex.Pokedex
import br.com.simpledex.domain.model.pokemon.Pokemon

data class PokedexUI(
    val pokedex: Pokedex? = null,
    val pokemonList: List<Pokemon> = emptyList(),
    val filteredPokemonList: List<Pokemon> = emptyList(),
    val searchText: String = "",
    val isSearching: Boolean = false
)