package br.com.simpledex.data.remote.service.di

import br.com.simpledex.data.remote.service.*
import br.com.simpledex.data.remote.service.ServiceManager
import org.koin.dsl.module

val apiModules = module {

    single { ServiceManager() }

    single { get<ServiceManager>().create(PokemonService::class.java) }

    single { get<ServiceManager>().create(PokedexService::class.java) }

    single { get<ServiceManager>().create(GenerationService::class.java) }

}
