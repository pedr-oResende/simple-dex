package br.com.simpledex.data.model.move

import br.com.simpledex.data.model.game.version.VersionGroupDetailsResponse
import br.com.simpledex.domain.model.move.Move
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class MovesResponse(
    @SerializedName("move") val move: MoveResponse?,
    @SerializedName("version_group_details") val versionGroupDetails: List<VersionGroupDetailsResponse>
)

