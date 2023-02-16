package br.com.simpledex.data.mapper.icons

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.icons.IconsResponse
import br.com.simpledex.domain.model.icons.Icons

class IconsResponseToEntityMapper : Mapper<IconsResponse, Icons> {
    override fun map(input: IconsResponse) = input.run {
        Icons(
            frontDefault = frontDefault,
            frontFemale = frontFemale
        )
    }
}