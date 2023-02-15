package br.com.simpledex.data.model.game.games

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GoldResponse(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_transparent") val frontTransparent: String?
)