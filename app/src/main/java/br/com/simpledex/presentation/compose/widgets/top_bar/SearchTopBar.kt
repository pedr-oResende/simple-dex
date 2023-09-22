package br.com.simpledex.presentation.compose.widgets.top_bar

import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme
import br.com.simpledex.presentation.compose.widgets.edit_text.SearchEditText
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexEvents

@Composable
fun SearchTopBar(
    searchText: String,
    placeholderText: String,
    onClearClick: () -> Unit,
    onSearchTextChanged: (String) -> Unit
) {
    val (showClearButton, setShowClearButton) = remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    TopBar(title = "") {
        SearchEditText(
            searchText = searchText,
            onSearchTextChanged = onSearchTextChanged,
            placeholder = placeholderText,
            showClearButton = showClearButton,
            setShowClearButton = setShowClearButton,
            keyboardController = keyboardController,
            focusRequester = focusRequester,
            onClearClick = onClearClick
        )
    }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

@Preview
@Composable
private fun SearchTopBarPrev() {
    SimpleDexTheme {
        SearchTopBar(
            searchText = "",
            placeholderText = "Nome do pokémon",
            onClearClick = { },
            onSearchTextChanged = { }
        )
    }
}