package br.com.simpledex.domain.repository

import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.model.base.PagedList
import br.com.simpledex.domain.model.pokemon.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(limit: Int, offset: Int): Flow<PagedList<PokemonList>>

    fun getPokemonById(id: Int): Flow<Pokemon>

    fun getPokemonByName(name: String): Flow<Pokemon>

}