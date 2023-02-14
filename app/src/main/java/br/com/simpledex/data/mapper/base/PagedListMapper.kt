package br.com.simpledex.data.mapper.base

import br.com.lighttasks.commom.mapper.Mapper
import br.com.simpledex.data.model.base.PagedListResponse
import br.com.simpledex.domain.model.base.PagedList

interface PagedListMapper<I, O> : Mapper<PagedListResponse<I>, PagedList<O>>