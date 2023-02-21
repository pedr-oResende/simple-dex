package br.com.simpledex.data.remote.model.ability

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class AbilitiesResponse(
    @SerializedName("ability") val ability: AbilityResponse?,
    @SerializedName("is_hidden") val isHidden: Boolean?,
    @SerializedName("slot") val slot: Int?
)