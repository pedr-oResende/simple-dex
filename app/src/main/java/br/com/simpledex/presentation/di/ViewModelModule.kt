package br.com.simpledex.presentation.di

import br.com.simpledex.presentation.screens.pokedex.PokedexViewModel
import org.koin.dsl.module

val viewModelModule = module {

    single {
        PokedexViewModel(
            getNationalDexUseCase = get(),
            getPokemonByNameUseCase = get(),
            getPokemonFromLocalUseCase = get()
        )
    }

}