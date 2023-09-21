package br.com.simpledex.data.remote.data_sources.pokedex

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexResponse
import br.com.simpledex.data.remote.service.PokedexService
import retrofit2.HttpException

class PokedexRemoteDataSourceImpl(
    private val service: PokedexService
) : PokedexRemoteDataSource {

    override suspend fun getPokedexList(limit: Int, offset: Int): PagedListResponse<ListItemResponse> {
        val response = service.getPokedexList(limit, offset)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }

    override suspend fun getPokedex(id: Int): PokedexResponse {
        val response = service.getPokedex(id)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }

}