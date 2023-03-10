package br.com.simpledex.data.repository

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.local.data_sources.PokemonLocalDataSource
import br.com.simpledex.data.local.model.PokemonTable
import br.com.simpledex.data.mapper.base.PagedListResponseToPagedListMapper
import br.com.simpledex.data.remote.model.pokemon.PokemonListResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import br.com.simpledex.data.remote.data_sources.PokemonRemoteDataSource
import br.com.simpledex.data.remote.util.apiCall
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.model.base.PagedList
import br.com.simpledex.domain.model.pokemon.PokemonList
import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    val remoteDataSource: PokemonRemoteDataSource,
    val localDataSource: PokemonLocalDataSource,
    val pokemonListResponseToEntityMapper: PagedListResponseToPagedListMapper<PokemonListResponse, PokemonList>,
    val pokemonResponseToEntityMapper: Mapper<PokemonResponse, Pokemon>,
    val localPokemonToEntityMapper: Mapper<PokemonTable, Pokemon>,
    val localListPokemonToEntityMapper: NullableListMapper<PokemonTable, Pokemon>,
    val pokemonToLocalEntityMapper: Mapper<Pokemon, PokemonTable>,
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
                if (localDataSource.containsId(id)) {
                    val localPokemon = localDataSource.getPokemonById(id)
                    val pokemon = localPokemonToEntityMapper.map(localPokemon)
                    emit(pokemon)
                } else {
                    val response = remoteDataSource.getPokemonById(id)
                    val mappedResponse = pokemonResponseToEntityMapper.map(response)
                    updateLocalDataBase(mappedResponse)
                    emit(mappedResponse)
                }
            }
        }
    }

    override fun getPokemonByName(name: String): Flow<Pokemon> {
        return flow {
            apiCall {
                if (localDataSource.containsName(name)) {
                    val localPokemon = localDataSource.getPokemonByName(name)
                    val pokemon = localPokemonToEntityMapper.map(localPokemon)
                    emit(pokemon)
                } else {
                    val response = remoteDataSource.getPokemonByName(name)
                    val mappedResponse = pokemonResponseToEntityMapper.map(response)
                    updateLocalDataBase(mappedResponse)
                    emit(mappedResponse)
                }
            }
        }
    }

    override fun getPokemonNameFromLocal(): Flow<List<String>> {
        return flow {
            val pokemon = localDataSource.getPokemonName()
            emit(pokemon)
        }
    }

    override fun getPokemonFromLocal(): Flow<List<Pokemon>> {
        return flow {
            val localPokemon = localDataSource.getPokemon()
            val pokemon = localListPokemonToEntityMapper.map(localPokemon)
            emit(pokemon)
        }
    }

    private suspend fun updateLocalDataBase(pokemon: Pokemon) {
        val localPokemon = pokemonToLocalEntityMapper.map(pokemon)
        localDataSource.insertPokemon(localPokemon)
    }

}