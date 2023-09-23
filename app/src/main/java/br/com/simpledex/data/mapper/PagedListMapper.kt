package br.com.simpledex.data.mapper

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.domain.model.base.PagedList

fun <I, O> PagedListResponse<I>.toPagedList(mapper: (List<I>?) -> List<O> ) = PagedList(
        count = count,
        next = next,
        previous = previous,
        results = mapper(results)
    )