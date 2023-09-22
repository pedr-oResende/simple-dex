package br.com.simpledex.data.remote.model.pokedex

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import com.google.gson.annotations.SerializedName

class PokedexResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("is_main_series") val isMainSeries: Boolean?,
    @SerializedName("name") val name: String?,
    @SerializedName("pokemon_entries") val pokemonEntries: List<PokedexEntryResponse>?,
)