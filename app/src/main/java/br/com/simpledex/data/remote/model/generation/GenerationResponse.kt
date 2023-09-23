package br.com.simpledex.data.remote.model.generation

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import com.google.gson.annotations.SerializedName

class GenerationResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("pokemon_species") val pokemonSpecies: List<ListItemResponse>?,
    @SerializedName("version_groups") val versionGroups: List<ListItemResponse>?
)