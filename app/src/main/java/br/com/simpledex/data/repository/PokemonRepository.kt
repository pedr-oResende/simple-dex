package br.com.simpledex.data.repository

import br.com.lighttasks.commom.mapper.Mapper
import br.com.simpledex.data.mapper.base.PagedListResponseToPagedListMapper
import br.com.simpledex.data.model.pokemon.PokemonListResponse
import br.com.simpledex.data.model.pokemon.PokemonResponse
import br.com.simpledex.data.remote.data_sources.PokemonRemoteDataSource
import br.com.simpledex.data.remote.util.apiCall
import br.com.simpledex.domain.model.Pokemon
import br.com.simpledex.domain.model.base.PagedList
import br.com.simpledex.domain.model.pokemon.PokemonList
import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    val remoteDataSource: PokemonRemoteDataSource,
    val pokemonListResponseToEntityMapper: PagedListResponseToPagedListMapper<PokemonListResponse, PokemonList>,
    val pokemonResponseToEntityMapper: Mapper<PokemonResponse, Pokemon>
) : PokemonRepository {
    override fun getPokemonList(limit: Int, offset: Int): Flow<PagedList<PokemonList>> {
        return flow {
            apiCall {
                val response = remoteDataSource.getPokemonList(limit, offset)
                val mappedResponse = pokemonListResponseToEntityMapper.map(response)
                emit(mappedResponse)
            }
        }
    }

    override fun getPokemonById(id: Int): Flow<Pokemon> {
        return flow {
            apiCall {
                val response = remoteDataSource.getPokemonById(id)
                val mappedResponse = pokemonResponseToEntityMapper.map(response)
                emit(mappedResponse)
            }
        }
    }

    override fun getPokemonByName(name: String): Flow<Pokemon> {
        return flow {
            apiCall {
                val response = remoteDataSource.getPokemonByName(name)
                val mappedResponse = pokemonResponseToEntityMapper.map(response)
                emit(mappedResponse)
            }
        }
    }

}