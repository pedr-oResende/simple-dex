package br.com.simpledex.data.remote.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationIIIResponse(
    @SerializedName("emerald") val emerald: EmeraldResponse?,
    @SerializedName("firered-leafgreen") val fireRedLeafGreen: FireRedLeafGreenResponse?,
    @SerializedName("ruby-sapphire") val rubySapphire: RubySapphireResponse?
)