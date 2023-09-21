package br.com.simpledex.data.mapper.base

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.domain.model.commom.ListItem

class ListItemResponseToEntityMapper : Mapper<ListItemResponse, ListItem> {
    override fun map(input: ListItemResponse) = input.run {
        ListItem(
            name = name.orEmpty(),
            url = url.orEmpty()
        )
    }
}