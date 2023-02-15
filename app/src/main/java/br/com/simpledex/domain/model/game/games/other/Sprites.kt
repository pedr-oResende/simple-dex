package br.com.simpledex.domain.model.game.games.other

import br.com.simpledex.domain.model.game.version.Versions

data class Sprites(
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?,
    val other: Other?,
    val versions: Versions?
)