package br.com.simpledex.data.local.data_sources

import br.com.simpledex.data.local.dao.PokemonDao
import br.com.simpledex.data.local.model.PokemonTable

class PokemonLocalDataSourceImpl(
    private val dao: PokemonDao
) : PokemonLocalDataSource{

    override suspend  fun insertPokemon(pokemon: PokemonTable) {
        dao.insertPokemon(pokemon)
    }

    override suspend  fun getPokemonByName(name: String): PokemonTable? {
        return dao.getPokemonByName(name)
    }

    override suspend  fun getPokemonById(id: Int): PokemonTable? {
        return dao.getPokemonById(id)
    }
}