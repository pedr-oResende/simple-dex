package br.com.simpledex.data.model.game.games.other

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class TypeResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)