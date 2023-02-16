package br.com.simpledex.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import br.com.simpledex.domain.model.pokemon.Pokemon
import coil.compose.rememberAsyncImagePainter

@Composable
fun PokemonItem(
    modifier: Modifier = Modifier,
    pokemon: Pokemon
) {
    val typesColor = pokemon.types?.map { it.type?.color!! }.orEmpty()
    val background = if (typesColor.size > 1)
        modifier.background(brush = Brush.horizontalGradient(colors = typesColor, tileMode = TileMode.Decal))
    else
        modifier.background(color = typesColor.first())
    Row(
        modifier = background.padding(all = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        pokemon.sprites?.versions?.generationVII?.icons?.frontDefault?.let { sprite ->
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
            text = pokemon.name.orEmpty(),
            color = contentColorFor(backgroundColor = typesColor.first())
        )
    }
}