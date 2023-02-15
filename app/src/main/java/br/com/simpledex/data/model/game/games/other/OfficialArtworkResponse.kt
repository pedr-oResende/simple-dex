package br.com.simpledex.data.model.game.games.other

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class OfficialArtworkResponse(
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?
)