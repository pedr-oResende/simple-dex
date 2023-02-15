package br.com.simpledex.data.model.game.version

import br.com.simpledex.domain.model.move.MoveLearnMethod
import br.com.simpledex.domain.model.game.version.VersionGroup
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class VersionGroupDetailsResponse(
    @SerializedName("level_learned_at") val levelLearnedAt: Int?,
    @SerializedName("move_learn_method") val moveLearnMethod: MoveLearnMethod?,
    @SerializedName("version_group") val versionGroup: VersionGroup?
)