package br.com.simpledex.data.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVIResponse(
    @SerializedName("omegaruby-alphasapphire") val omegaRubyAlphaSapphire: OmegaRubyAlphaSapphireResponse?,
    @SerializedName("x-y") val xy: XYResponse
)