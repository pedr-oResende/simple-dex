package br.com.simpledex.data.repository

import br.com.simpledex.data.mapper.toEntity
import br.com.simpledex.data.remote.data_sources.generation.GenerationRemoteDataSource
import br.com.simpledex.data.remote.util.apiCall
import br.com.simpledex.domain.model.generation.Generation
import br.com.simpledex.domain.repository.GenerationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GenerationRepositoryImpl(
    private val remoteDataSource: GenerationRemoteDataSource
) : GenerationRepository {

    override fun getGeneration(name: String): Flow<Generation> {
        return flow {
            apiCall {
                val response = remoteDataSource.getGeneration(name)
                emit(response.toEntity())
            }
        }
    }

}