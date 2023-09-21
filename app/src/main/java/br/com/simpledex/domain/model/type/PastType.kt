package br.com.simpledex.domain.model.type

import br.com.simpledex.domain.model.commom.ListItem

data class PastType(
    val generation: ListItem?,
    val types: List<Types>?
)