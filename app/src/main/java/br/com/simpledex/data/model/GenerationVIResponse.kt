package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationVIResponse(
    @SerializedName("omegaruby-alphasapphire") val omegaRubyAlphaSapphire: OmegaRubyAlphaSapphireResponse?,
    @SerializedName("x-y") val xy: XYResponse
)