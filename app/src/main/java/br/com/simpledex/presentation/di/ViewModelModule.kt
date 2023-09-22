package br.com.simpledex.presentation.di

import br.com.simpledex.presentation.screens.home.HomeViewModel
import br.com.simpledex.presentation.screens.pokedex.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel(
            getPokedexListUseCase = get()
        )
    }

    viewModel { (id: Int) ->
        PokedexViewModel(
            getPokedexUseCase = get(),
            getPokemonByNameUseCase = get(),
            id = id
        )
    }

}