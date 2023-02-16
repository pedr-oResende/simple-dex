package br.com.simpledex.data.mapper.game.other

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.game.games.other.OfficialArtworkResponse
import br.com.simpledex.domain.model.game.games.other.OfficialArtwork

class OfficialArtworkResponseToEntityMapper : Mapper<OfficialArtworkResponse, OfficialArtwork> {
    override fun map(input: OfficialArtworkResponse) = input.run {
        OfficialArtwork(
            frontDefault = frontDefault,
            frontShiny = frontShiny
        )
    }
}