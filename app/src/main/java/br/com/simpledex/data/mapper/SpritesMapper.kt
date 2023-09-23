package br.com.simpledex.data.mapper

import br.com.simpledex.data.remote.model.sprites.SpritesResponse
import br.com.simpledex.domain.model.sprites.Sprites

fun SpritesResponse.toEntity() = Sprites(
    backDefault = backDefault,
    backFemale = backFemale,
    backShiny = backShiny,
    backShinyFemale = backShinyFemale,
    frontDefault = frontDefault,
    frontFemale = frontFemale,
    frontShiny = frontShiny,
    frontShinyFemale = frontShinyFemale
)