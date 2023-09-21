package br.com.simpledex.data.mapper.pokedex

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexResponse
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.pokedex.Pokedex

class PokedexResponseToEntityMapper(
    private val pokemonEntriesResponseToListMapper: NullableListMapper<ListItemResponse, ListItem>
) : Mapper<PokedexResponse, Pokedex> {
    override fun map(input: PokedexResponse) = input.run {
        Pokedex(
            id = id ?: 0,
            name = name.orEmpty(),
            isMainSeries = isMainSeries ?: true,
            pokemonEntries = pokemonEntriesResponseToListMapper.map(pokemonEntries)
        )
    }
}