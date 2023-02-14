package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVResponse(
    @SerializedName("black-white") val blackWhite: BlackWhiteResponse?
)