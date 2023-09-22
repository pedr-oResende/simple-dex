package br.com.simpledex.data.remote.data_sources.pokemon

import br.com.simpledex.data.remote.model.pokemon.PokemonResponse

interface PokemonRemoteDataSource {

    suspend fun getPokemonById(id: Int): PokemonResponse

    suspend fun getPokemonByName(name: String): PokemonResponse

}