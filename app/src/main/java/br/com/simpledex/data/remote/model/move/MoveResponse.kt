package br.com.simpledex.data.remote.model.move

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class MoveResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)