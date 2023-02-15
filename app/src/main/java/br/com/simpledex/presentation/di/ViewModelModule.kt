package br.com.simpledex.presentation.di

import br.com.simpledex.presentation.screens.home.HomeViewModel
import org.koin.dsl.module

val viewModelModule = module {

    single {
        HomeViewModel(
            getNationalDexUseCase = get()
        )
    }

}