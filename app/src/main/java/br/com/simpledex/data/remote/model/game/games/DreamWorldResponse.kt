package br.com.simpledex.data.remote.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class DreamWorldResponse(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?
)