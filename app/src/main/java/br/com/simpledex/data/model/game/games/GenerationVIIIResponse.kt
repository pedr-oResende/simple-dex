package br.com.simpledex.data.model.game.games

import br.com.simpledex.data.model.icons.IconsResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVIIIResponse(
    @SerializedName("icons") val icons: IconsResponse?
)