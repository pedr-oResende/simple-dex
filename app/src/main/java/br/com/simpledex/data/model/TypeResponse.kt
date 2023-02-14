package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class TypeResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)