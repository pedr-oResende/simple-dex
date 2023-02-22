package br.com.simpledex.data.mapper.pokemon

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.local.model.PokemonTable
import br.com.simpledex.domain.model.pokemon.Pokemon
import com.google.gson.Gson

class LocalPokemonToEntityMapper : Mapper<PokemonTable, Pokemon> {
    override fun map(input: PokemonTable): Pokemon =
        Gson().fromJson(input.pokemonJson, Pokemon::class.java)
}