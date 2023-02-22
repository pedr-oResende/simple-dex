package br.com.simpledex.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.simpledex.data.local.dao.PokemonDao
import br.com.simpledex.data.local.model.PokemonTable

@Database(
    entities = [PokemonTable::class],
    version = 1,
    exportSchema = false
)
abstract class PokemonDatabase : RoomDatabase() {

    abstract val pokemonDao: PokemonDao

    companion object {
        const val DATABASE_NAME = "pokemon_database"
    }
}