package br.com.simpledex.presentation.screens.pokedex.ui

import br.com.simpledex.commom.extension.pagedListOf
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.model.base.PagedList

data class PokedexUI(
    val pagedPokemonList: PagedList<Pokemon> = pagedListOf(),
    val pokemonList: List<Pokemon> = emptyList(),
    val filteredPokemonList: List<Pokemon> = emptyList(),
    val searchText: String = "",
    val isSearching: Boolean = false
)