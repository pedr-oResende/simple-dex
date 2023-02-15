package br.com.simpledex.data.model.game.games.other

import br.com.simpledex.domain.model.game.games.other.Stat
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class StatsResponse(
    @SerializedName("base_stat") val baseStat: Int?,
    @SerializedName("effort") val effort: Int?,
    @SerializedName("stat") val stat: Stat?
)