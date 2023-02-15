package br.com.simpledex.data.model.game.games

import br.com.simpledex.domain.model.icons.Icons
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVIIIResponse(
    @SerializedName("icons") val icons: Icons?
)