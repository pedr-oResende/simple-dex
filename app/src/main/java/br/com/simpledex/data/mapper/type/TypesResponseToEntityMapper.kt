package br.com.simpledex.data.mapper.type

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.type.TypeResponse
import br.com.simpledex.data.model.type.TypesResponse
import br.com.simpledex.domain.model.type.Type
import br.com.simpledex.domain.model.type.Types

class TypesResponseToEntityMapper(
    private val typeResponseToEntityMapper: Mapper<TypeResponse, Type>
) : Mapper<TypesResponse, Types> {
    override fun map(input: TypesResponse) = input.run {
        Types(
            type = if (type != null) typeResponseToEntityMapper.map(type) else null,
            slot = slot
        )
    }
}