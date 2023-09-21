package br.com.simpledex.data.remote.service

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("/api/v2/pokemon/")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : Response<PagedListResponse<ListItemResponse>>

    @GET("/api/v2/pokemon/{id}")
    suspend fun getPokemonById(
        @Path("id") id: Int
    ) : Response<PokemonResponse>

    @GET("/api/v2/pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") name: String
    ) : Response<PokemonResponse>

    suspend fun getPokedexList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : Response<PagedListResponse<ListItemResponse>>

}