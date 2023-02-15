package br.com.simpledex.data.model.game.games

import br.com.simpledex.domain.model.game.games.DiamondPearl
import br.com.simpledex.domain.model.game.games.HeartGoldSoulSilver
import br.com.simpledex.domain.model.game.games.Platinum
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationIVResponse(
    @SerializedName("diamond-pearl") val diamondPearl: DiamondPearl?,
    @SerializedName("heartgold-soulsilver") val heartGoldSoulSilver: HeartGoldSoulSilver?,
    @SerializedName("platinum") val platinum: Platinum?
)