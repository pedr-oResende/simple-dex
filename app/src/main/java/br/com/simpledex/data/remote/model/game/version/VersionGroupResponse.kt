package br.com.simpledex.data.remote.model.game.version

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class VersionGroupResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)