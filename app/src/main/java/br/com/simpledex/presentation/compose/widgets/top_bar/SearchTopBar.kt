package br.com.simpledex.presentation.compose.widgets.top_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.tooling.preview.Preview
import br.com.simpledex.presentation.compose.animation.FadeAnimation
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme
import br.com.simpledex.presentation.compose.widgets.edit_text.SearchEditText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    title: String,
    searchText: String,
    onBackPressed: (() -> Unit)? = null,
    onClearClick: () -> Unit,
    onSearchTextChanged: (String) -> Unit,
    placeholderText: String
) {
    var isSearching by remember { mutableStateOf(false) }
    FadeAnimation(visible = !isSearching) {
        TopBar(
            title = title,
            onBackPressed = onBackPressed,
            actions = {
                TopBarIcon(
                    onClick = { isSearching = true },
                    imageVector = Icons.Default.Search
                )
            }
        )
    }
    FadeAnimation(visible = isSearching) {
        TopBar(title = "") {
            SearchEditText(
                searchText = searchText,
                onSearchTextChanged = onSearchTextChanged,
                placeholder = placeholderText,
                onClearClick = {
                    isSearching = false
                    onClearClick()
                }
            )
        }
    }
}

@Preview
@Composable
private fun SearchTopBarPrev() {
    SimpleDexTheme {
        SearchTopBar(
            title = "TopBar Title",
            searchText = "",
            placeholderText = "Nome do pokémon",
            onClearClick = { },
            onSearchTextChanged = { }
        )
    }
}