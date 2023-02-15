package br.com.simpledex.data.model.game

import br.com.simpledex.data.model.game.version.VersionResponse
import com.google.gson.annotations.SerializedName


class GameIndicesResponse(
    @SerializedName("game_index") val gameIndex: Int?,
    @SerializedName("version") val version: VersionResponse?
)