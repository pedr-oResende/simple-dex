package br.com.simpledex.data.mapper.type

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.model.type.GenerationResponse
import br.com.simpledex.data.model.type.PastTypeResponse
import br.com.simpledex.data.model.type.TypesResponse
import br.com.simpledex.domain.model.type.Generation
import br.com.simpledex.domain.model.type.PastType
import br.com.simpledex.domain.model.type.Types

class PastTypeResponseToEntityMapper(
    private val generationResponseToEntityMapper: Mapper<GenerationResponse, Generation>,
    private val typesResponseToEntityMapper: NullableListMapper<TypesResponse, Types>
) : Mapper<PastTypeResponse, PastType> {
    override fun map(input: PastTypeResponse) = input.run { 
        PastType(
            generation = if (generation != null)
                generationResponseToEntityMapper.map(generation) else null,
            types = typesResponseToEntityMapper.map(types)
        )
    }
}