package br.com.simpledex.data.remote.service.di

import br.com.simpledex.data.remote.service.ServiceManager
import br.com.simpledex.BuildConfig
import br.com.simpledex.data.remote.service.PokemonService
import org.koin.dsl.module

val apiModules = module {

    single { ServiceManager(BuildConfig.BASE_URL) }

    single { get<ServiceManager>().create(PokemonService::class.java) }

}
