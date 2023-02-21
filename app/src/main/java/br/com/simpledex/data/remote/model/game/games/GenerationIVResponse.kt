package br.com.simpledex.data.remote.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationIVResponse(
    @SerializedName("diamond-pearl") val diamondPearl: DiamondPearlResponse?,
    @SerializedName("heartgold-soulsilver") val heartGoldSoulSilver: HeartGoldSoulSilverResponse?,
    @SerializedName("platinum") val platinum: PlatinumResponse?
)