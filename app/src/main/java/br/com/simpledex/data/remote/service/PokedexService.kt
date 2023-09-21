package br.com.simpledex.data.remote.service

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexResponse
import retrofit2.Response
import retrofit2.http.*

interface PokedexService {

    @GET("/api/v2/pokedex/")
    suspend fun getPokedexList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : Response<PagedListResponse<ListItemResponse>>

    @GET("/api/v2/pokedex/{id}")
    suspend fun getPokedex(
        @Path("id") id: Int
    ) : Response<PokedexResponse>

}