package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class AbilitiesResponse(
    @SerializedName("ability") val ability: AbilityResponse?,
    @SerializedName("is_hidden") val isHidden: Boolean?,
    @SerializedName("slot") val slot: Int?
)