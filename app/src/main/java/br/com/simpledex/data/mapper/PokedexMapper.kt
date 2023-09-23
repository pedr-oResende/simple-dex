package br.com.simpledex.data.mapper

import br.com.simpledex.commom.extension.nullableMap
import br.com.simpledex.data.remote.model.pokedex.PokedexEntryResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexResponse
import br.com.simpledex.domain.model.pokedex.Pokedex
import br.com.simpledex.domain.model.pokedex.PokedexEntry

fun PokedexEntryResponse.toEntity() = PokedexEntry(
    pokedexNumber = pokedexNumber ?: 0,
    pokemon = pokemon?.toEntity()
)

fun PokedexResponse.toEntity() = Pokedex(
    id = id ?: 0,
    name = name.orEmpty(),
    isMainSeries = isMainSeries ?: true,
    pokemonEntries = pokemonEntries.nullableMap { it.toEntity() }
)