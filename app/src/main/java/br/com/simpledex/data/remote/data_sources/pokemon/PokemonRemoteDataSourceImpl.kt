package br.com.simpledex.data.remote.data_sources.pokemon

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import br.com.simpledex.data.remote.service.PokemonService
import retrofit2.HttpException

class PokemonRemoteDataSourceImpl(
    private val service: PokemonService
) : PokemonRemoteDataSource {

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