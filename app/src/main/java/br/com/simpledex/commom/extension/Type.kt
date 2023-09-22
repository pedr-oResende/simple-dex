package br.com.simpledex.commom.extension

import br.com.simpledex.presentation.model.PokemonType

fun PokemonType.isColorDark(): Boolean {
    return this == PokemonType.DARK || this == PokemonType.GHOST
}