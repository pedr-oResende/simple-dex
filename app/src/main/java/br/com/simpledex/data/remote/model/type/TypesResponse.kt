package br.com.simpledex.data.remote.model.type

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class TypesResponse(
    @SerializedName("slot") val slot: Int?,
    @SerializedName("type") val type: TypeResponse?
)