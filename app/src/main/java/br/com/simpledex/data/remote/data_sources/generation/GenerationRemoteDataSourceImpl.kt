package br.com.simpledex.data.remote.data_sources.generation

import br.com.simpledex.data.remote.model.generation.GenerationResponse
import br.com.simpledex.data.remote.service.GenerationService
import retrofit2.HttpException

class GenerationRemoteDataSourceImpl(
    private val service: GenerationService
) : GenerationRemoteDataSource {

    override suspend fun getGeneration(name: String): GenerationResponse {
        val response = service.getGeneration(name)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }

}