package br.com.simpledex.domain.model.stat

import br.com.simpledex.domain.model.commom.ListItem

data class Stats(
    val baseStat: Int?,
    val effort: Int?,
    val stat: ListItem?
)