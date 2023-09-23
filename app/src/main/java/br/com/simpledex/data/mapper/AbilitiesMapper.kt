package br.com.simpledex.data.mapper

import br.com.simpledex.data.remote.model.ability.AbilitiesResponse
import br.com.simpledex.domain.model.ability.Abilities

fun AbilitiesResponse.toEntity() = Abilities(
    ability = ability?.toEntity(),
    isHidden = isHidden,
    slot = slot
)