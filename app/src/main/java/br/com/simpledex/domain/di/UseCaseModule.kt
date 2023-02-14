package br.com.simpledex.domain.di

import br.com.simpledex.domain.use_case.GetNationalDexUseCase
import br.com.simpledex.domain.use_case.GetPokemonByIdUseCase
import org.koin.dsl.module

val useCaseModule = module {

    single { GetPokemonByIdUseCase(get()) }

    single { GetNationalDexUseCase(get()) }

}