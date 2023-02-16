package br.com.simpledex.data.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationIResponse(
    @SerializedName("red-blue") val redBlue: RedBlueResponse?,
    @SerializedName("yellow") val yellow: YellowResponse?
)