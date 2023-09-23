package br.com.simpledex.data.mapper

import br.com.simpledex.commom.extension.nullableMap
import br.com.simpledex.data.remote.model.generation.GenerationResponse
import br.com.simpledex.domain.model.generation.Gen
import br.com.simpledex.domain.model.generation.Generation

fun GenerationResponse.toEntity() = Generation(
    id = id,
    gen = Gen.getByName(name),
    pokemonSpecies = pokemonSpecies.nullableMap { it.toEntity() },
    versionGroups = versionGroups.nullableMap { it.toEntity() }
)