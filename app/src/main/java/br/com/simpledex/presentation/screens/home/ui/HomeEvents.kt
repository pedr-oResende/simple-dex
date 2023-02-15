package br.com.simpledex.presentation.screens.home.ui

sealed interface HomeEvents {
    data class SearchTextChanged(val text: String) : HomeEvents
    object OpenSearchBar : HomeEvents
    object CloseSearchBar : HomeEvents
}