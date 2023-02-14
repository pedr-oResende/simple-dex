package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class MovesResponse(
    @SerializedName("move") val move: MoveResponse?,
    @SerializedName("version_group_details") val versionGroupDetails: List<VersionGroupDetailsResponse>
)

