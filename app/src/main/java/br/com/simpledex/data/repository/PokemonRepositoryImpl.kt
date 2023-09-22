package br.com.simpledex.data.repository

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.local.data_sources.PokemonLocalDataSource
import br.com.simpledex.data.local.model.PokemonTable
import br.com.simpledex.data.remote.data_sources.pokemon.PokemonRemoteDataSource
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import br.com.simpledex.data.remote.util.apiCall
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    val remoteDataSource: PokemonRemoteDataSource,
    val localDataSource: PokemonLocalDataSource,
    val pokemonResponseToEntityMapper: Mapper<PokemonResponse, Pokemon>,
    val localPokemonToEntityMapper: Mapper<PokemonTable, Pokemon>,
    val pokemonToLocalEntityMapper: Mapper<Pokemon, PokemonTable>
) : PokemonRepository {

    override fun getPokemonById(id: Int): Flow<Pokemon> {
        return flow {
            apiCall {
                val localPokemon = localDataSource.getPokemonById(id)
                if (localPokemon != null) {
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
                val localPokemon = localDataSource.getPokemonByName(name)
                if (localPokemon != null) {
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

    private suspend fun updateLocalDataBase(pokemon: Pokemon) {
        val localPokemon = pokemonToLocalEntityMapper.map(pokemon)
        localDataSource.insertPokemon(localPokemon)
    }

}