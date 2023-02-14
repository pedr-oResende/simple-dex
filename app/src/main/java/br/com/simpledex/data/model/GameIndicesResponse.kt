package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName


data class GameIndicesResponse(
    @SerializedName("game_index") val gameIndex: Int?,
    @SerializedName("version") val version: VersionResponse?
)