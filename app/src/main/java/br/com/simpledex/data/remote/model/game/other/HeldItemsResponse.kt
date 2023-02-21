package br.com.simpledex.data.remote.model.game.other

import br.com.simpledex.data.remote.model.game.version.VersionDetailResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class HeldItemsResponse(
    @SerializedName("item") val item: HeldItemResponse?,
    @SerializedName("version_details")  val versionDetails: List<VersionDetailResponse>?
)