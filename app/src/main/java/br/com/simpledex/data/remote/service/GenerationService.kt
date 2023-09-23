package br.com.simpledex.data.remote.service

import br.com.simpledex.data.remote.model.generation.GenerationResponse
import retrofit2.Response
import retrofit2.http.*

interface GenerationService {

    @GET("/api/v2/generation/{name}")
    suspend fun getGeneration(
        @Path("name") name: String
    ) : Response<GenerationResponse>

}