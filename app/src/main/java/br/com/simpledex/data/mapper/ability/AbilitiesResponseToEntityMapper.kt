package br.com.simpledex.data.mapper.ability

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.ability.AbilitiesResponse
import br.com.simpledex.data.model.ability.AbilityResponse
import br.com.simpledex.domain.model.ability.Abilities
import br.com.simpledex.domain.model.ability.Ability

class AbilitiesResponseToEntityMapper(
    private val abilityResponseToEntityMapper: Mapper<AbilityResponse, Ability>
) : Mapper<AbilitiesResponse, Abilities> {
    override fun map(input: AbilitiesResponse) = input.run {
        Abilities(
            ability = if (ability != null) abilityResponseToEntityMapper.map(ability) else null,
            isHidden = isHidden,
            slot = slot
        )
    }
}