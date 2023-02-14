package br.com.simpledex.data.remote.data_sources

import br.com.simpledex.data.model.base.PagedListResponse
import br.com.simpledex.data.model.pokemon.PokemonListResponse
import br.com.simpledex.data.model.pokemon.PokemonResponse

interface PokemonRemoteDataSource {

    suspend fun getPokemonList(limit: Int, offset: Int): PagedListResponse<PokemonListResponse>

    suspend fun getPokemonById(id: Int): PokemonResponse

    suspend fun getPokemonByName(name: String): PokemonResponse

}