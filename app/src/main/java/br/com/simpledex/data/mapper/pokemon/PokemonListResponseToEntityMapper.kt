package br.com.simpledex.data.mapper.pokemon

import br.com.lighttasks.commom.mapper.Mapper
import br.com.simpledex.data.model.pokemon.PokemonListResponse
import br.com.simpledex.domain.model.pokemon.PokemonList

class PokemonListResponseToEntityMapper : Mapper<PokemonListResponse, PokemonList> {
    override fun map(input: PokemonListResponse) = input.run {
        PokemonList(
            name = name,
            url = url
        )
    }
}