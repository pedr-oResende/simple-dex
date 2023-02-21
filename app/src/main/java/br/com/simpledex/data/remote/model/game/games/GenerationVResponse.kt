package br.com.simpledex.data.remote.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVResponse(
    @SerializedName("black-white") val blackWhite: BlackWhiteResponse?
)