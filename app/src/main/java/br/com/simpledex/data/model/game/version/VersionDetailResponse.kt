package br.com.simpledex.data.model.game.version

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class VersionDetailResponse(
    @SerializedName("rarity") val rarity: Int?,
    @SerializedName("version") val version: VersionResponse?
)