package br.com.simpledex.data.remote.model.game.version

import br.com.simpledex.data.remote.model.move.MoveLearnMethodResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class VersionGroupDetailsResponse(
    @SerializedName("level_learned_at") val levelLearnedAt: Int?,
    @SerializedName("move_learn_method") val moveLearnMethod: MoveLearnMethodResponse?,
    @SerializedName("version_group") val versionGroup: VersionGroupResponse?
)