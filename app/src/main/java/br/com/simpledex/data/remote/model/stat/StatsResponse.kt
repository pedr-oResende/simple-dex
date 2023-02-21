package br.com.simpledex.data.remote.model.stat

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class StatsResponse(
    @SerializedName("base_stat") val baseStat: Int?,
    @SerializedName("effort") val effort: Int?,
    @SerializedName("stat") val stat: StatResponse?
)