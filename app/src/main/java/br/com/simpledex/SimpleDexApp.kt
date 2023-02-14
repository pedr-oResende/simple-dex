package br.com.simpledex

import android.app.Application
import br.com.simpledex.data.di.mapperModule
import br.com.simpledex.data.di.repositoryModule
import br.com.simpledex.data.remote.service.di.apiModules
import br.com.simpledex.data.remote.util.preferences.PreferencesWrapper
import br.com.simpledex.domain.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SimpleDexApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PreferencesWrapper.initPreferences(this)
        initKoinModules()
    }

    private fun initKoinModules() {
        startKoin {
            androidContext(this@SimpleDexApp)
            modules(
                apiModules,
                mapperModule,
                repositoryModule,
                useCaseModule
            )
        }
    }

}