package br.com.simpledex.data.remote.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationIIResponse(
    @SerializedName("crystal") val crystal: CrystalResponse?,
    @SerializedName("gold") val gold: GoldResponse?,
    @SerializedName("silver") val silver: SilverResponse?
)