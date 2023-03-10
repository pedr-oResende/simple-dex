package br.com.simpledex.data.mapper.game.other

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.game.other.SpeciesResponse
import br.com.simpledex.domain.model.game.other.Species

class SpeciesResponseToEntityMapper : Mapper<SpeciesResponse, Species> {
    override fun map(input: SpeciesResponse) = input.run {
        Species(
            name = name,
            url = url
        )
    }
}