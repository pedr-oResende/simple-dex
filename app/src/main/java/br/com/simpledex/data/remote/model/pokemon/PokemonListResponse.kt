package br.com.simpledex.data.remote.model.pokemon

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class PokemonListResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
)