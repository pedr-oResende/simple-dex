package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVIIIResponse(
    @SerializedName("icons") val icons: IconsResponse?
)