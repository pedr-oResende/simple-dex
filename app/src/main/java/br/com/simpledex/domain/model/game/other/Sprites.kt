package br.com.simpledex.domain.model.game.other

import br.com.simpledex.domain.model.game.version.Versions

data class Sprites(
    val backDefault: String? = null,
    val backFemale: String? = null,
    val backShiny: String? = null,
    val backShinyFemale: String? = null,
    val frontDefault: String? = null,
    val frontFemale: String? = null,
    val frontShiny: String? = null,
    val frontShinyFemale: String? = null,
    val other: Other? = null,
    val versions: Versions? = null
)