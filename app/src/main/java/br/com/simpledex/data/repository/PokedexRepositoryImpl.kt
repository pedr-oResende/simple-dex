package br.com.simpledex.data.repository

import br.com.simpledex.commom.extension.nullableMap
import br.com.simpledex.data.mapper.toEntity
import br.com.simpledex.data.mapper.toPagedList
import br.com.simpledex.data.remote.data_sources.pokedex.PokedexRemoteDataSource
import br.com.simpledex.data.remote.util.apiCall
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.pokedex.Pokedex
import br.com.simpledex.domain.repository.PokedexRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokedexRepositoryImpl(
    private val remoteDataSource: PokedexRemoteDataSource
) : PokedexRepository {

    override fun getPokedexList(limit: Int, offset: Int): Flow<List<ListItem>> {
        return flow {
            apiCall {
                val response = remoteDataSource.getPokedexList(limit, offset)
                val mappedResponse = response.toPagedList { responseList ->
                    responseList.nullableMap { pokedex -> pokedex.toEntity() }
                }
                emit(mappedResponse.results)
            }
        }
    }

    override fun getPokedex(id: Int): Flow<Pokedex> {
        return flow {
            apiCall {
                val response = remoteDataSource.getPokedex(id)
                emit(response.toEntity())
            }
        }
    }

}