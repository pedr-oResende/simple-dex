package br.com.simpledex.data.mapper

import br.com.simpledex.commom.extension.*
import br.com.simpledex.data.remote.model.pokedex.PokedexEntryResponse
import br.com.simpledex.data.remote.model.pokedex.PokedexResponse
import br.com.simpledex.domain.model.pokedex.Pokedex
import br.com.simpledex.domain.model.pokedex.PokedexEntry

fun PokedexEntryResponse.toEntity() = PokedexEntry(
    pokedexNumber = pokedexNumber.orZero(),
    pokemon = pokemon?.toEntity()
)

fun PokedexResponse.toEntity() = Pokedex(
    id = id.orZero(),
    name = name.orEmpty(),
    isMainSeries = isMainSeries ifNull true,
    pokemonEntries = pokemonEntries.nullableMap { it.toEntity() }
)