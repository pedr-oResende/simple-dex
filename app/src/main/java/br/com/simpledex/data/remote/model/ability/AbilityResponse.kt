package br.com.simpledex.data.remote.model.ability

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class AbilityResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)