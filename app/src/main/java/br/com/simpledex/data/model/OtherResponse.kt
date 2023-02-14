package br.com.simpledex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class OtherResponse(
    @SerializedName("dream_world") val dreamWorld: DreamWorldResponse?,
    @SerializedName("home") val home: HomeResponse?,
    @SerializedName("official-artwork") val officialArtwork: OfficialArtworkResponse?
)