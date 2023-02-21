package br.com.simpledex.data.mapper.game.version

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.game.games.GenerationVIIResponse
import br.com.simpledex.data.remote.model.game.version.VersionsResponse
import br.com.simpledex.domain.model.game.games.GenerationVII
import br.com.simpledex.domain.model.game.version.Versions

class VersionsResponseToEntityMapper(
    private val generationVIIResponseToEntityMapper: Mapper<GenerationVIIResponse, GenerationVII>
) : Mapper<VersionsResponse, Versions> {

    override fun map(input: VersionsResponse) = input.run {
        Versions(
            generationVII = if (generationVII != null)
                generationVIIResponseToEntityMapper.map(generationVII) else null
        )
    }
}