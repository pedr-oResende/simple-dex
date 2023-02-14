package br.com.simpledex.data.remote.data_sources

import br.com.simpledex.data.model.base.PagedListResponse
import br.com.simpledex.data.model.pokemon.PokemonListResponse
import br.com.simpledex.data.model.pokemon.PokemonResponse
import br.com.simpledex.data.remote.service.PokemonService
import retrofit2.HttpException

class PokemonRemoteDataSourceImpl(
    private val service: PokemonService
) : PokemonRemoteDataSource {
    override suspend fun getPokemonList(limit: Int, offset: Int): PagedListResponse<PokemonListResponse> {
        val response = service.getPokemonList(limit, offset)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }

    override suspend fun getPokemonById(id: Int): PokemonResponse {
        val response = service.getPokemonById(id)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }

    override suspend fun getPokemonByName(name: String): PokemonResponse {
        val response = service.getPokemonByName(name)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw HttpException(response)
        }
    }


}