package br.com.simpledex.data.remote.model.pokedex

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class PokedexEntryResponse(
    @SerializedName("entry_number") val pokedexNumber: Int?,
    @SerializedName("pokemon_species") val pokemon: ListItemResponse?
)