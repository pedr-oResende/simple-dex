package br.com.simpledex.data.remote.model.type

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class PastTypeResponse(
    @SerializedName("generation") val generation: GenerationResponse?,
    @SerializedName("types") val types: List<TypesResponse>?
)