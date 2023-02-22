package br.com.simpledex.data.local.di

import androidx.room.Room
import br.com.simpledex.data.local.database.PokemonDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            PokemonDatabase::class.java,
            PokemonDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    single { get<PokemonDatabase>().pokemonDao }

}