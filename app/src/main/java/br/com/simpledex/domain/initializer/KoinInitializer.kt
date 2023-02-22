package br.com.simpledex.domain.initializer

import android.content.Context
import androidx.startup.Initializer
import br.com.simpledex.data.di.mapperModule
import br.com.simpledex.data.di.repositoryModule
import br.com.simpledex.data.local.di.databaseModule
import br.com.simpledex.data.remote.service.di.apiModules
import br.com.simpledex.domain.di.useCaseModule
import br.com.simpledex.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinInitializer : Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
        return startKoin {
            androidContext(context)
            modules(
                apiModules,
                mapperModule,
                repositoryModule,
                useCaseModule,
                viewModelModule,
                databaseModule
            )
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}