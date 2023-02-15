package br.com.simpledex.data.mapper.ability

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.ability.AbilityResponse
import br.com.simpledex.domain.model.ability.Ability

class AbilityResponseToEntityMapper : Mapper<AbilityResponse, Ability> {
    override fun map(input: AbilityResponse) = input.run {
        Ability(
            name = name,
            url = url
        )
    }
}