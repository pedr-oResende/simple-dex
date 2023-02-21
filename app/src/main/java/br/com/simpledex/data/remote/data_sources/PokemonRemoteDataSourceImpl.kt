package br.com.simpledex.data.remote.data_sources

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonListResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import br.com.simpledex.data.remote.service.PokemonService
import retrofit2.HttpException

class PokemonRemoteDataSourceImpl(
    private val service: PokemonService
) : PokemonRemoteDataSource {
    override suspend fun getPokemonList(limit: Int, offset: Int): br.com.simpledex.data.remote.model.base.PagedListResponse<br.com.simpledex.data.remote.model.pokemon.PokemonListResponse> {
        val response = service.getPokemonList(limit, offset)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }

    override suspend fun getPokemonById(id: Int): br.com.simpledex.data.remote.model.pokemon.PokemonResponse {
        val response = service.getPokemonById(id)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }

    override suspend fun getPokemonByName(name: String): br.com.simpledex.data.remote.model.pokemon.PokemonResponse {
        val response = service.getPokemonByName(name)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }


}