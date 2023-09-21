package br.com.simpledex.data.remote.model.game.version

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class VersionDetailResponse(
    @SerializedName("rarity") val rarity: Int?,
    @SerializedName("version") val version: ListItemResponse?
)