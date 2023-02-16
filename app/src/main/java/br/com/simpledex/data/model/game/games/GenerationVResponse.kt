package br.com.simpledex.data.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVResponse(
    @SerializedName("black-white") val blackWhite: BlackWhiteResponse?
)