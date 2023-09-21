package br.com.simpledex.data.remote.data_sources.pokedex

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexResponse

interface PokedexRemoteDataSource {

    suspend fun getPokedexList(limit: Int, offset: Int): PagedListResponse<ListItemResponse>

    suspend fun getPokedex(id: Int): PokedexResponse

}