package br.com.simpledex.data.mapper.game.other

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.game.games.other.OfficialArtworkResponse
import br.com.simpledex.data.model.game.games.other.OtherResponse
import br.com.simpledex.domain.model.game.games.other.OfficialArtwork
import br.com.simpledex.domain.model.game.games.other.Other

class OtherResponseToEntityMapper(
    private val officialArtworkResponseToEntityMapper: Mapper<OfficialArtworkResponse, OfficialArtwork>
) : Mapper<OtherResponse, Other> {
    override fun map(input: OtherResponse) = input.run {
        Other(
            officialArtwork = if (officialArtwork != null)
                officialArtworkResponseToEntityMapper.map(officialArtwork) else null
        )
    }
}