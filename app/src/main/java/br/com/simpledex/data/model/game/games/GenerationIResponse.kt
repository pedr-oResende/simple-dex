package br.com.simpledex.data.model.game.games

import br.com.simpledex.domain.model.game.games.RedBlue
import br.com.simpledex.domain.model.game.games.Yellow
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationIResponse(
    @SerializedName("red-blue") val redBlue: RedBlue?,
    @SerializedName("yellow") val yellow: Yellow?
)