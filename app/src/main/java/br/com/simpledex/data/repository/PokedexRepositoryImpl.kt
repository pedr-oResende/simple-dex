package br.com.simpledex.data.repository

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.mapper.base.PagedListResponseToPagedListMapper
import br.com.simpledex.data.remote.data_sources.pokedex.PokedexRemoteDataSource
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexResponse
import br.com.simpledex.data.remote.util.apiCall
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.pokedex.Pokedex
import br.com.simpledex.domain.repository.PokedexRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokedexRepositoryImpl(
    private val remoteDataSource: PokedexRemoteDataSource,
    private val pokedexListResponseToEntityMapper: PagedListResponseToPagedListMapper<ListItemResponse, ListItem>,
    private val pokedexResponseToEntityMapper: Mapper<PokedexResponse, Pokedex>
) : PokedexRepository {

    override fun getPokedexList(limit: Int, offset: Int): Flow<List<ListItem>> {
        return flow {
            apiCall {
                val response = remoteDataSource.getPokedexList(limit, offset)
                val mappedResponse = pokedexListResponseToEntityMapper.map(response)
                emit(mappedResponse.results)
            }
        }
    }

    override fun getPokedex(id: Int): Flow<Pokedex> {
        return flow {
            apiCall {
                val response = remoteDataSource.getPokedex(id)
                val mappedResponse = pokedexResponseToEntityMapper.map(response)
                emit(mappedResponse)
            }
        }
    }

}