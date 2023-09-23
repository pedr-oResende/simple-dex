package br.com.simpledex.data.mapper

import br.com.simpledex.commom.extension.nullableMap
import br.com.simpledex.data.remote.model.type.PastTypeResponse
import br.com.simpledex.data.remote.model.type.TypesResponse
import br.com.simpledex.domain.model.type.PastType
import br.com.simpledex.domain.model.type.Types
import br.com.simpledex.presentation.model.PokemonType

fun PastTypeResponse.toEntity() = PastType(
    generation = generation?.toEntity(),
    types = types.nullableMap { it.toEntity() }
)

fun TypesResponse.toEntity() = Types(
    type = br.com.simpledex.commom.extension.enumValueOf(this.type?.name?.uppercase().orEmpty(), PokemonType.NONE),
    slot = slot
)