package br.com.simpledex.data.di

import br.com.simpledex.data.mapper.pokemon.PokemonListResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.PokemonResponseToEntityMapper
import org.koin.dsl.module

val mapperModule = module {

    single { PokemonResponseToEntityMapper() }

    single { PokemonListResponseToEntityMapper() }

}