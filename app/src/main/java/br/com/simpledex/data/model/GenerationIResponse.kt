package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIResponse(
    @SerializedName("red-blue") val redBlue: RedBlueResponse?,
    @SerializedName("yellow") val yellow: YellowResponse?
)