package br.com.simpledex.domain.model.game.games

import br.com.simpledex.data.model.icons.IconsResponse
import br.com.simpledex.domain.model.icons.Icons
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVIII(
    @SerializedName("icons") val icons: IconsResponse?
)