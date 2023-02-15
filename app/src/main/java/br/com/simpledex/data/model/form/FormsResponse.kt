package br.com.simpledex.data.model.form

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class FormsResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)