package br.com.simpledex.data.remote.model.game.games

import br.com.simpledex.data.remote.model.icons.IconsResponse
import br.com.simpledex.domain.model.icons.Icons
import br.com.simpledex.domain.model.game.games.UltraSunUltraMoon
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVIIResponse(
    @SerializedName("icons") val icons: IconsResponse?,
    @SerializedName("ultra-sun-ultra-moon") val ultraSunUltraMoon: UltraSunUltraMoonResponse?
)