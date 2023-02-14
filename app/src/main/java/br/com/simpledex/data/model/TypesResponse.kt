package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class TypesResponse(
    @SerializedName("slot") val slot: Int?,
    @SerializedName("type") val type: TypeResponse?
)