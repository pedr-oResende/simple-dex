package br.com.simpledex.data.remote.model.commom

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class ListItemResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)