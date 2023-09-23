package br.com.simpledex.presentation.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.simpledex.domain.model.generation.Gen
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme
import coil.compose.rememberAsyncImagePainter

@Composable
fun GenerationItem(
    modifier: Modifier = Modifier,
    name: String,
    backgroundImage: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.large
            )
            .shadow(
                elevation = 2.dp,
                shape = MaterialTheme.shapes.large
            )
            .clip(MaterialTheme.shapes.large)
            .clickable {
                onClick()
            },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primaryContainer),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.large
            ) {
                Box {
                    Image(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(all = 16.dp)
                            .fillMaxSize()
                            .alpha(0.5f)
                            .clip(MaterialTheme.shapes.large),
                        painter = rememberAsyncImagePainter(model = backgroundImage),
                        contentDescription = null
                    )
                }
            }
            Box(modifier = Modifier.weight(1f)) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = name.uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
private fun GenerationItemPrev() {
    SimpleDexTheme {
        GenerationItem(
            modifier = Modifier.size(128.dp),
            name = Gen.One.title,
            backgroundImage = Gen.One.image,
            onClick = {}
        )
    }
}