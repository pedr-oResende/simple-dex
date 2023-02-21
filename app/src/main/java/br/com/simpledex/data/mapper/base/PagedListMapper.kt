package br.com.simpledex.data.mapper.base

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.domain.model.base.PagedList

interface PagedListMapper<I, O> : Mapper<PagedListResponse<I>, PagedList<O>>