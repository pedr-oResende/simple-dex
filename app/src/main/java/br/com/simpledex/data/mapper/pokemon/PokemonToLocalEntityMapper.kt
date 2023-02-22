package br.com.simpledex.data.mapper.pokemon

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.local.model.PokemonTable
import br.com.simpledex.domain.model.pokemon.Pokemon
import com.google.gson.Gson

class PokemonToLocalEntityMapper : Mapper<Pokemon, PokemonTable> {
    override fun map(input: Pokemon) = input.run {
        PokemonTable(
            id = id,
            name = name,
            pokemonJson = Gson().toJson(this)
        )
    }
}