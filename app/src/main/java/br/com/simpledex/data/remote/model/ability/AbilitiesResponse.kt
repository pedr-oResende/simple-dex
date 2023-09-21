package br.com.simpledex.data.remote.model.ability

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class AbilitiesResponse(
    @SerializedName("ability") val ability: ListItemResponse?,
    @SerializedName("is_hidden") val isHidden: Boolean?,
    @SerializedName("slot") val slot: Int?
)