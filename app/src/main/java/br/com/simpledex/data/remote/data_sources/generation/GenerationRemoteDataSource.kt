package br.com.simpledex.data.remote.data_sources.generation

import br.com.simpledex.data.remote.model.generation.GenerationResponse

interface GenerationRemoteDataSource {

    suspend fun getGeneration(name: String): GenerationResponse

}