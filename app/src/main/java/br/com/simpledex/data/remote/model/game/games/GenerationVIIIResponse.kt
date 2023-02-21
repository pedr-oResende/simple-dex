package br.com.simpledex.data.remote.model.game.games

import br.com.simpledex.data.remote.model.icons.IconsResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVIIIResponse(
    @SerializedName("icons") val icons: IconsResponse?
)