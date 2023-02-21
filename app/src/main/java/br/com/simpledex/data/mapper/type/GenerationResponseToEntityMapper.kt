package br.com.simpledex.data.mapper.type

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.type.GenerationResponse
import br.com.simpledex.domain.model.type.Generation

class GenerationResponseToEntityMapper : Mapper<GenerationResponse, Generation> {
    override fun map(input: GenerationResponse) = input.run {
        Generation(
            name = name,
            url = url
        )
    }
}