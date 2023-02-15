package br.com.simpledex.data.model.game.games

import br.com.simpledex.domain.model.game.games.BlackWhite
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVResponse(
    @SerializedName("black-white") val blackWhite: BlackWhite?
)