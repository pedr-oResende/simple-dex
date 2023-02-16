package br.com.simpledex.data.model.game.other

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class SpeciesResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)