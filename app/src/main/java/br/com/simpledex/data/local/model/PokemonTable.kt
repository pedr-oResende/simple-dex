package br.com.simpledex.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
class PokemonTable(
    @PrimaryKey val id: Int?,
    val name: String?,
    val pokemonJson: String?
)