package br.com.simpledex.data.local.data_sources

import br.com.simpledex.data.local.model.PokemonTable

interface PokemonLocalDataSource {

    suspend  fun getPokemon(): List<PokemonTable>

    suspend  fun getPokemonName(): List<String>

    suspend  fun insertPokemon(pokemon: PokemonTable)

    suspend  fun containsName(name: String): Boolean

    suspend  fun containsId(id: Int): Boolean

    suspend  fun getPokemonByName(name: String): PokemonTable

    suspend  fun getPokemonById(id: Int): PokemonTable

}