package br.com.simpledex.data.remote.model.type

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class PastTypeResponse(
    @SerializedName("generation") val generation: ListItemResponse?,
    @SerializedName("types") val types: List<TypesResponse>?
)