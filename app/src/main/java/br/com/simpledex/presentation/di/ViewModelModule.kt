package br.com.simpledex.presentation.di

import br.com.simpledex.presentation.screens.generation.GenerationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { (name: String) ->
        GenerationViewModel(
            getGenerationUseCase = get(),
            getPokemonByIdUseCase = get(),
            name = name
        )
    }

}