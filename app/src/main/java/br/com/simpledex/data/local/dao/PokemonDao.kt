package br.com.simpledex.data.local.dao

import androidx.room.*
import br.com.simpledex.data.local.model.PokemonTable

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonTable)

    @Query("SELECT * FROM pokemon WHERE name = :name")
    suspend fun getPokemonByName(name: String) : PokemonTable?

    @Query("SELECT * FROM pokemon WHERE id = :id")
    suspend fun getPokemonById(id: Int) : PokemonTable?

}