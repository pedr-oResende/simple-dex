package br.com.simpledex.data.mapper

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.domain.model.commom.ListItem

fun ListItemResponse.toEntity() = ListItem(
    name = name.orEmpty(),
    url = url.orEmpty()
)