package br.com.simpledex.data.model.game.version

import br.com.simpledex.data.model.*
import br.com.simpledex.data.model.game.games.*
import br.com.simpledex.domain.model.game.games.*
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class VersionsResponse(
    @SerializedName("generation-i") val generationI: GenerationI?,
    @SerializedName("generation-ii") val generationII: GenerationII?,
    @SerializedName("generation-iii") val generationIII: GenerationIII?,
    @SerializedName("generation-iv") val generationIV: GenerationIV?,
    @SerializedName("generation-v") val generationV: GenerationV?,
    @SerializedName("generation-vi") val generationVI: GenerationVI?,
    @SerializedName("generation-vii") val generationVII: GenerationVII?,
    @SerializedName("generation-viii") val generationVIII: GenerationVIII?
)