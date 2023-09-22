package br.com.simpledex.presentation.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme

@Composable
fun PokedexItem(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .aspectRatio(1f)
            .border(width = 2.dp, color = MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.medium)
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onClick()
            },
        tonalElevation = 2.dp,
    ) {
        Box(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
private fun PokedexItemPrev() {
    SimpleDexTheme {
        PokedexItem(
            modifier = Modifier.size(128.dp),
            name = "National",
            onClick = {}
        )
    }
}