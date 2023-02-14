package br.com.simpledex.data.model.base

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class PagedListResponse<T>(
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<T>
)