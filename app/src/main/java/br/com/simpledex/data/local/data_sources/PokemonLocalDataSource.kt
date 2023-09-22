package br.com.simpledex.data.local.data_sources

import br.com.simpledex.data.local.model.PokemonTable

interface PokemonLocalDataSource {

    suspend  fun insertPokemon(pokemon: PokemonTable)

    suspend  fun getPokemonByName(name: String): PokemonTable?

    suspend  fun getPokemonById(id: Int): PokemonTable?

}