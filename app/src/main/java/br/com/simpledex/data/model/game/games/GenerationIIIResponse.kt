package br.com.simpledex.data.model.game.games

import br.com.simpledex.domain.model.game.games.Emerald
import br.com.simpledex.domain.model.game.games.FireRedLeafGreen
import br.com.simpledex.domain.model.game.games.RubySapphire
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationIIIResponse(
    @SerializedName("emerald") val emerald: Emerald?,
    @SerializedName("firered-leafgreen") val fireRedLeafGreen: FireRedLeafGreen?,
    @SerializedName("ruby-sapphire") val rubySapphire: RubySapphire?
)