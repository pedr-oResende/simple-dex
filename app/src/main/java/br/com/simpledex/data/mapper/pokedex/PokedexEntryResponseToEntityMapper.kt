package br.com.simpledex.data.mapper.pokedex

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexEntryResponse
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.pokedex.PokedexEntry

class PokedexEntryResponseToEntityMapper(
    private val pokemonResponseToEntityMapper: Mapper<ListItemResponse, ListItem>
) : Mapper<PokedexEntryResponse, PokedexEntry> {
    override fun map(input: PokedexEntryResponse) = input.run {
        PokedexEntry(
            pokedexNumber = pokedexNumber ?: 0,
            pokemon = pokemon?.let { pokemonResponseToEntityMapper.map(pokemon) }
        )
    }
}