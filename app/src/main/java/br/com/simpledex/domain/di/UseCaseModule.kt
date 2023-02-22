package br.com.simpledex.domain.di

import br.com.simpledex.domain.use_case.*
import org.koin.dsl.module

val useCaseModule = module {

    single { GetPokemonByIdUseCase(get()) }

    single { GetPokemonByNameUseCase(get()) }

    single { GetNationalDexUseCase(get()) }

    single { GetPokemonNameFromLocalUseCase(get()) }

    single { GetPokemonFromLocalUseCase(get()) }

}