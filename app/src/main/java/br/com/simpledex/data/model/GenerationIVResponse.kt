package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class GenerationIVResponse(
    @SerializedName("diamond-pearl") val diamondPearl: DiamondPearlResponse?,
    @SerializedName("heartgold-soulsilver") val heartGoldSoulSilver: HeartGoldSoulSilverResponse?,
    @SerializedName("platinum") val platinum: PlatinumResponse?
)