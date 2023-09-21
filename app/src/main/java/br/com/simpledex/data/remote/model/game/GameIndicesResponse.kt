package br.com.simpledex.data.remote.model.game

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import com.google.gson.annotations.SerializedName


class GameIndicesResponse(
    @SerializedName("game_index") val gameIndex: Int?,
    @SerializedName("version") val version: ListItemResponse?
)