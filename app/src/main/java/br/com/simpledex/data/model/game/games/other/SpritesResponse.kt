package br.com.simpledex.data.model.game.games.other

import br.com.simpledex.data.model.game.version.VersionsResponse
import br.com.simpledex.domain.model.game.games.other.Other
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class SpritesResponse(
    @SerializedName("back_default") val backDefault: String?,
    @SerializedName("back_female") val backFemale: String?,
    @SerializedName("back_shiny") val backShiny: String?,
    @SerializedName("back_shiny_female") val backShinyFemale: String?,
    @SerializedName("front_default") val frontDefault: String?,
    @SerializedName("front_female") val frontFemale: String?,
    @SerializedName("front_shiny") val frontShiny: String?,
    @SerializedName("front_shiny_female") val frontShinyFemale: String?,
    @SerializedName("other") val other: OtherResponse?,
    @SerializedName("versions") val versions: VersionsResponse?
)