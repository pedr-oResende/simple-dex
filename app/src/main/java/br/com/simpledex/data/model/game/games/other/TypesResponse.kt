package br.com.simpledex.data.model.game.games.other

import br.com.simpledex.domain.model.game.games.other.Type
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
class TypesResponse(
    @SerializedName("slot") val slot: Int?,
    @SerializedName("type") val type: Type?
)