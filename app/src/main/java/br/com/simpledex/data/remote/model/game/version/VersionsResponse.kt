package br.com.simpledex.data.remote.model.game.version

import br.com.simpledex.data.remote.model.*
import br.com.simpledex.data.remote.model.game.games.*
import br.com.simpledex.domain.model.game.games.*
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class VersionsResponse(
    @SerializedName("generation-i") val generationI: GenerationIResponse?,
    @SerializedName("generation-ii") val generationII: GenerationIIResponse?,
    @SerializedName("generation-iii") val generationIII: GenerationIIIResponse?,
    @SerializedName("generation-iv") val generationIV: GenerationIVResponse?,
    @SerializedName("generation-v") val generationV: GenerationVResponse?,
    @SerializedName("generation-vi") val generationVI: GenerationVIResponse?,
    @SerializedName("generation-vii") val generationVII: GenerationVIIResponse?,
    @SerializedName("generation-viii") val generationVIII: GenerationVIIIResponse?
)