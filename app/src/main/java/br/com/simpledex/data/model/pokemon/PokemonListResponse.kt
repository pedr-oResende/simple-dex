package br.com.simpledex.data.model.pokemon

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
)