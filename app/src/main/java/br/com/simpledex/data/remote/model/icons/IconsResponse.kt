package br.com.simpledex.data.remote.model.icons

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class IconsResponse(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?
)