package br.com.simpledex.presentation.screens.generation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.simpledex.commom.extension.ifNull
import br.com.simpledex.commom.extension.isColorDark
import br.com.simpledex.domain.model.pokemon.dummyPokemons
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme
import br.com.simpledex.presentation.model.PokemonType
import coil.compose.rememberAsyncImagePainter

@Composable
fun PokemonItem(
    modifier: Modifier = Modifier,
    name: String?,
    types: List<PokemonType>?,
    sprite: String?,
    onCLick: () -> Unit
) {
    val typesColor = types?.map { it.color }.orEmpty()
    val background =
        modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
            .clickable {
                onCLick()
            }
            .background(
                brush = if (typesColor.size > 1) Brush.horizontalGradient(
                    colors = typesColor,
                    tileMode = TileMode.Decal
                ) else
                    SolidColor(typesColor.first())
            )

    Row(
        modifier = background.padding(vertical = 4.dp, horizontal = 16.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        sprite?.let { sprite ->
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = rememberAsyncImagePainter(sprite),
                contentDescription = null
            )
        }
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = name.orEmpty(),
            color = if (types?.first()?.isColorDark() == true) {
                MaterialTheme.colorScheme.surface
            } else {
                MaterialTheme.colorScheme.onSurface
            }
        )
    }
}

@Preview
@Composable
private fun PokemonItemPrev() {
    SimpleDexTheme {
        val pokemon = dummyPokemons.first()
        PokemonItem(
            name = pokemon.name,
            types = pokemon.types?.map { it.type ifNull PokemonType.NONE },
            sprite = pokemon.sprites?.frontDefault,
            onCLick = {}
        )
    }
}