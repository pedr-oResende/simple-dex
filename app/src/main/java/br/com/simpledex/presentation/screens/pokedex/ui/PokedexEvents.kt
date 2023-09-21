package br.com.simpledex.presentation.screens.pokedex.ui

sealed interface PokedexEvents {
    data class SearchTextChanged(val text: String) : PokedexEvents
    data object OpenSearchBar : PokedexEvents
    data object CloseSearchBar : PokedexEvents
}