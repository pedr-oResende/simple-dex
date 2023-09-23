package br.com.simpledex.domain.di

import br.com.simpledex.domain.use_case.generation.GetGenerationUseCase
import br.com.simpledex.domain.use_case.pokedex.GetPokedexListUseCase
import br.com.simpledex.domain.use_case.pokemon.*
import org.koin.dsl.module

val useCaseModule = module {

    single { GetPokemonByIdUseCase(get()) }

    single { GetPokemonByNameUseCase(get()) }

    single { GetPokedexListUseCase(get()) }

    single { GetPokedexUseCase(get()) }

    single { GetGenerationUseCase(get()) }

}