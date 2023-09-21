package br.com.simpledex.data.remote.model.game.version

import br.com.simpledex.data.remote.model.commom.ListItemResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class VersionGroupDetailsResponse(
    @SerializedName("level_learned_at") val levelLearnedAt: Int?,
    @SerializedName("move_learn_method") val moveLearnMethod: ListItemResponse?,
    @SerializedName("version_group") val versionGroup: ListItemResponse?
)