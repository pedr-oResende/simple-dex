package br.com.simpledex.data.mapper

import br.com.simpledex.commom.extension.nullableMap
import br.com.simpledex.data.local.model.PokemonTable
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import br.com.simpledex.domain.model.pokemon.Pokemon
import com.google.gson.Gson

fun PokemonResponse.toEntity() = Pokemon(
    id = id,
    name = name,
    height = height,
    weight = weight,
    isDefault = isDefault,
    order = order,
    locationAreaEncounters = locationAreaEncounters,
    baseExperience = baseExperience,
    pastTypes = pastTypes.nullableMap { it.toEntity() } ,
    abilities = abilities.nullableMap { it.toEntity() },
    forms = forms.nullableMap { it.toEntity() },
    moves = moves.nullableMap { it.toEntity() },
    types = types.nullableMap { it.toEntity() },
    stats = stats.nullableMap { it.toEntity() },
    species = species?.toEntity(),
    sprites = sprites?.toEntity()
)

fun PokemonTable.toEntity(): Pokemon = Gson().fromJson(pokemonJson, Pokemon::class.java)

fun Pokemon.toTable() = PokemonTable(
    id = id,
    name = name,
    pokemonJson = Gson().toJson(this)
)