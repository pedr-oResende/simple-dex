package br.com.simpledex.data.mapper.base

import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.domain.model.base.PagedList


class PagedListResponseToPagedListMapper<I, O>(
    private val listMapper: NullableListMapper<I, O>
) : PagedListMapper<I, O> {
    override fun map(input: PagedListResponse<I>) = input.run {
        PagedList(
            count = count,
            next = next,
            previous = previous,
            results = listMapper.map(results)
        )
    }
}