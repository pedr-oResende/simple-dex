package br.com.simpledex.data.mapper.type

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.type.TypesResponse
import br.com.simpledex.domain.model.type.Types
import br.com.simpledex.commom.extension.enumValueOf
import br.com.simpledex.presentation.model.PokemonType

class TypesResponseToEntityMapper : Mapper<TypesResponse, Types> {
    override fun map(input: TypesResponse) = input.run {
        Types(
            type = enumValueOf(type?.name?.uppercase().orEmpty(), PokemonType.NONE),
            slot = slot
        )
    }
}