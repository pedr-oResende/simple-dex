package br.com.simpledex.data.remote.data_sources

import br.com.simpledex.data.remote.model.base.PagedListResponse
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import br.com.simpledex.domain.model.commom.ListItem

interface PokemonRemoteDataSource {

    suspend fun getPokemonList(limit: Int, offset: Int): PagedListResponse<ListItemResponse>

    suspend fun getPokemonById(id: Int): PokemonResponse

    suspend fun getPokemonByName(name: String): PokemonResponse

}