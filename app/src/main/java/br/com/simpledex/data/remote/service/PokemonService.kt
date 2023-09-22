package br.com.simpledex.data.remote.service

import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("/api/v2/pokemon/{id}")
    suspend fun getPokemonById(
        @Path("id") id: Int
    ) : Response<PokemonResponse>

    @GET("/api/v2/pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") name: String
    ) : Response<PokemonResponse>

}