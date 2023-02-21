package br.com.simpledex.data.remote.data_sources

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonListResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse

interface PokemonRemoteDataSource {

    suspend fun getPokemonList(limit: Int, offset: Int): br.com.simpledex.data.remote.model.base.PagedListResponse<br.com.simpledex.data.remote.model.pokemon.PokemonListResponse>

    suspend fun getPokemonById(id: Int): br.com.simpledex.data.remote.model.pokemon.PokemonResponse

    suspend fun getPokemonByName(name: String): br.com.simpledex.data.remote.model.pokemon.PokemonResponse

}