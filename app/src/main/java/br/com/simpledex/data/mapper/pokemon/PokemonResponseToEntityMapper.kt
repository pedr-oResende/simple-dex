package br.com.simpledex.data.mapper.pokemon

import br.com.lighttasks.commom.mapper.Mapper
import br.com.simpledex.data.model.pokemon.PokemonResponse
import br.com.simpledex.domain.model.Pokemon

class PokemonResponseToEntityMapper : Mapper<PokemonResponse, Pokemon> {
    override fun map(input: PokemonResponse): Pokemon = input.run {
        Pokemon(
            name = name
        )
    }
}