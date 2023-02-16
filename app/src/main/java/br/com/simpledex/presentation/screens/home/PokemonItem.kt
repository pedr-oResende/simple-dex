package br.com.simpledex.presentation.screens.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import br.com.simpledex.domain.model.pokemon.Pokemon

@Composable
fun PokemonItem(
    modifier: Modifier = Modifier,
    pokemon: Pokemon
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = pokemon.name.orEmpty(),
        textAlign = TextAlign.Center
    )
}