package br.com.simpledex.data.mapper.game.other

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.game.other.OtherResponse
import br.com.simpledex.data.remote.model.game.other.SpritesResponse
import br.com.simpledex.data.remote.model.game.version.VersionsResponse
import br.com.simpledex.domain.model.game.other.Other
import br.com.simpledex.domain.model.game.other.Sprites
import br.com.simpledex.domain.model.game.version.Versions

class SpritesResponseToEntityMapper(
    private val otherResponseToEntityMapper: Mapper<OtherResponse, Other>,
    private val versionsResponseToEntityMapper: Mapper<VersionsResponse, Versions>,
) : Mapper<SpritesResponse, Sprites> {
    override fun map(input: SpritesResponse) = input.run {
        Sprites(
            backDefault = backDefault,
            backFemale = backFemale,
            backShiny = backShiny,
            backShinyFemale = backShinyFemale,
            frontDefault = frontDefault,
            frontFemale = frontFemale,
            frontShiny = frontShiny,
            frontShinyFemale = frontShinyFemale,
            other = if (other != null) otherResponseToEntityMapper.map(other) else null,
            versions = if (versions != null) versionsResponseToEntityMapper.map(versions) else null
        )
    }
}