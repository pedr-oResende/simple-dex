package br.com.simpledex.presentation.compose.widgets.top_bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    onBackPressed: (() -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis)
        },
        navigationIcon = {
            if (onBackPressed != null) {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            actionIconContentColor = contentColorFor(containerColor),
            navigationIconContentColor = contentColorFor(containerColor),
            titleContentColor = contentColorFor(containerColor)
        )
    )
}

@Preview
@Composable
fun TopBarPrev() {
    SimpleDexTheme {
        TopBar(
            title = "TopBar title",
            onBackPressed = {}
        ) {
            TopBarIcon(onClick = {}, imageVector = Icons.Default.Search)
        }
    }
}