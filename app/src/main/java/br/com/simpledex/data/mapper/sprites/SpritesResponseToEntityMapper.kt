package br.com.simpledex.data.mapper.sprites

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.sprites.SpritesResponse
import br.com.simpledex.domain.model.sprites.Sprites

class SpritesResponseToEntityMapper : Mapper<SpritesResponse, Sprites> {
    override fun map(input: SpritesResponse) = input.run {
        Sprites(
            backDefault = backDefault,
            backFemale = backFemale,
            backShiny = backShiny,
            backShinyFemale = backShinyFemale,
            frontDefault = frontDefault,
            frontFemale = frontFemale,
            frontShiny = frontShiny,
            frontShinyFemale = frontShinyFemale
        )
    }
}