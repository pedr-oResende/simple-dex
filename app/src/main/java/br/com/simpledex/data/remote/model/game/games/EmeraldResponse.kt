package br.com.simpledex.data.remote.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class EmeraldResponse(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)