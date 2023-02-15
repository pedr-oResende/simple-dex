package br.com.simpledex.data.model.game.games

import br.com.simpledex.domain.model.game.games.OmegaRubyAlphaSapphire
import br.com.simpledex.domain.model.game.games.XY
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class GenerationVIResponse(
    @SerializedName("omegaruby-alphasapphire") val omegaRubyAlphaSapphire: OmegaRubyAlphaSapphire?,
    @SerializedName("x-y") val xy: XY
)