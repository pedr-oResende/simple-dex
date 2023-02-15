package br.com.simpledex.commom.extension

import br.com.simpledex.domain.model.base.PagedList

fun <T> pagedListOf() = PagedList(
    count = 0,
    next = null,
    previous = null,
    results = emptyList<T>()
)