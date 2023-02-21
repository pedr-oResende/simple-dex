package br.com.simpledex.data.model.type

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)