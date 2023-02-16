package br.com.simpledex.data.model.stat

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class StatResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)