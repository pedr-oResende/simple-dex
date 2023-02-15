package br.com.simpledex.data.mapper.game.indice

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.game.GameIndicesResponse
import br.com.simpledex.data.model.game.version.VersionResponse
import br.com.simpledex.domain.model.game.GameIndices
import br.com.simpledex.domain.model.game.version.Version

class GameIndicesResponseToEntityMapper(
    private val versionResponseToEntityMapper: Mapper<VersionResponse, Version>
) : Mapper<GameIndicesResponse, GameIndices> {
    override fun map(input: GameIndicesResponse) = input.run {
        GameIndices(
            gameIndex = gameIndex,
            version = if (version != null) versionResponseToEntityMapper.map(version) else null
        )
    }

}