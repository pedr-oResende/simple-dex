package br.com.simpledex.data.mapper.type

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.type.TypeResponse
import br.com.simpledex.domain.model.type.Type

class TypeResponseToEntityMapper : Mapper<TypeResponse, Type> {
    override fun map(input: TypeResponse) = input.run {
        Type(
            name = name,
            url = url
        )
    }
}