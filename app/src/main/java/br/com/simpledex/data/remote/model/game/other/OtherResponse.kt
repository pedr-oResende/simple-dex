package br.com.simpledex.data.remote.model.game.other

import br.com.simpledex.data.remote.model.game.games.DreamWorldResponse
import br.com.simpledex.data.remote.model.game.games.HomeResponse
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class OtherResponse(
    @SerializedName("dream_world") val dreamWorld: DreamWorldResponse?,
    @SerializedName("home") val home: HomeResponse?,
    @SerializedName("official-artwork") val officialArtwork: OfficialArtworkResponse?
)