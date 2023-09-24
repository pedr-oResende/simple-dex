package br.com.simpledex.presentation.screens.generation.ui

sealed interface GenerationEvents {
    data class SearchTextChanged(val text: String) : GenerationEvents
}