package br.com.simpledex.domain.model.game.games

import br.com.simpledex.domain.model.sprites.Animated

data class BlackWhite(
    val animated: Animated?,
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?
)