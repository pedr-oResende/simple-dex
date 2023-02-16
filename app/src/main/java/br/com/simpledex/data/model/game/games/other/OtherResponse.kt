package br.com.simpledex.data.model.game.games.other

import br.com.simpledex.data.model.game.games.DreamWorldResponse
import br.com.simpledex.data.model.game.games.HomeResponse
import br.com.simpledex.domain.model.game.games.other.OfficialArtwork
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class OtherResponse(
    @SerializedName("dream_world") val dreamWorld: DreamWorldResponse?,
    @SerializedName("home") val home: HomeResponse?,
    @SerializedName("official-artwork") val officialArtwork: OfficialArtworkResponse?
)