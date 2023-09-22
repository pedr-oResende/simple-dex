package br.com.simpledex.domain.repository

import br.com.simpledex.domain.model.pokemon.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonById(id: Int): Flow<Pokemon>

    fun getPokemonByName(name: String): Flow<Pokemon>

}