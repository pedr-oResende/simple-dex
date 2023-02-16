package br.com.simpledex.data.mapper.game.games

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.game.games.UltraSunUltraMoonResponse
import br.com.simpledex.domain.model.game.games.UltraSunUltraMoon

class UltraSunUltraMoonResponseToEntityMapper : Mapper<UltraSunUltraMoonResponse, UltraSunUltraMoon> {
    override fun map(input: UltraSunUltraMoonResponse) = input.run {
        UltraSunUltraMoon(
            frontShiny = frontShiny,
            frontDefault = frontDefault,
            frontShinyFemale = frontShinyFemale,
            frontFemale = frontFemale
        )
    }
}