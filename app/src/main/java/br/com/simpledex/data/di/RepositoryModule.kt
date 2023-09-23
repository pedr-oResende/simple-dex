package br.com.simpledex.data.di

import br.com.simpledex.data.local.data_sources.PokemonLocalDataSourceImpl
import br.com.simpledex.data.remote.data_sources.generation.GenerationRemoteDataSource
import br.com.simpledex.data.remote.data_sources.generation.GenerationRemoteDataSourceImpl
import br.com.simpledex.data.remote.data_sources.pokedex.PokedexRemoteDataSourceImpl
import br.com.simpledex.data.remote.data_sources.pokemon.PokemonRemoteDataSourceImpl
import br.com.simpledex.data.repository.*
import br.com.simpledex.domain.repository.*
import org.koin.dsl.module

val repositoryModule = module {

    single<PokemonRepository> {
        PokemonRepositoryImpl(
            remoteDataSource = PokemonRemoteDataSourceImpl(get()),
            localDataSource = PokemonLocalDataSourceImpl(get())
        )
    }

    single<PokedexRepository> {
        PokedexRepositoryImpl(
            remoteDataSource = PokedexRemoteDataSourceImpl(get())
        )
    }

    single<GenerationRepository> {
        GenerationRepositoryImpl(
            remoteDataSource = GenerationRemoteDataSourceImpl(get())
        )
    }

}