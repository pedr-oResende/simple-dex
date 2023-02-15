package br.com.simpledex.data.model.game.games

import br.com.simpledex.domain.model.game.games.Crystal
import br.com.simpledex.domain.model.game.games.Silver
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationIIResponse(
    @SerializedName("crystal") val crystal: Crystal?,
    @SerializedName("gold") val gold: GoldResponse?,
    @SerializedName("silver") val silver: Silver?
)