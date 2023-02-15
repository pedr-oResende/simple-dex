package br.com.simpledex.data.model.game.version

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class VersionResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String
)