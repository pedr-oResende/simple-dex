package br.com.simpledex.data.remote.model.move

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.game.version.VersionGroupDetailsResponse
import br.com.simpledex.domain.model.commom.ListItem
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class MovesResponse(
    @SerializedName("move") val move: ListItemResponse?,
    @SerializedName("version_group_details") val versionGroupDetails: List<VersionGroupDetailsResponse>
)

