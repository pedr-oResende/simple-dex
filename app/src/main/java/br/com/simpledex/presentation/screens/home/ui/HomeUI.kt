package br.com.simpledex.presentation.screens.home.ui

import br.com.simpledex.commom.extension.pagedListOf
import br.com.simpledex.domain.model.base.PagedList
import br.com.simpledex.domain.model.pokemon.PokemonList

data class HomeUI(
    val pokemonList: PagedList<PokemonList> = pagedListOf(),
    val filteredPokemonList: List<PokemonList> = emptyList(),
    val searchText: String = "",
    val isSearching: Boolean = false
)