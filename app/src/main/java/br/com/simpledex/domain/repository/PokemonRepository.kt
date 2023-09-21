package br.com.simpledex.domain.repository

import br.com.simpledex.domain.model.base.PagedList
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.pokemon.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(limit: Int, offset: Int): Flow<PagedList<ListItem>>

    fun getPokemonById(id: Int): Flow<Pokemon>

    fun getPokemonByName(name: String): Flow<Pokemon>

    fun getPokemonNameFromLocal(): Flow<List<String>>

    fun getPokemonFromLocal(): Flow<List<Pokemon>>

}