package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIIIResponse(
    @SerializedName("emerald") val emerald: EmeraldResponse?,
    @SerializedName("firered-leafgreen") val fireRedLeafGreen: FireRedLeafGreenResponse?,
    @SerializedName("ruby-sapphire") val rubySapphire: RubySapphireResponse?
)