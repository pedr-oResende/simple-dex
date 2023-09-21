package br.com.simpledex.data.remote.model.pokemon

import br.com.simpledex.*
import br.com.simpledex.data.remote.model.ability.AbilitiesResponse
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.game.GameIndicesResponse
import br.com.simpledex.data.remote.model.game.other.*
import br.com.simpledex.data.remote.model.move.MovesResponse
import br.com.simpledex.data.remote.model.stat.StatsResponse
import br.com.simpledex.data.remote.model.type.PastTypeResponse
import br.com.simpledex.data.remote.model.type.TypesResponse
import br.com.simpledex.domain.model.commom.ListItem
import com.google.gson.annotations.SerializedName

class PokemonResponse(
    @SerializedName("abilities") val abilities: List<AbilitiesResponse>?,
    @SerializedName("base_experience") val baseExperience: Int?,
    @SerializedName("forms") val forms: List<ListItemResponse>?,
    @SerializedName("game_indices") val gameIndices: List<GameIndicesResponse>?,
    @SerializedName("height") val height: Int?,
    @SerializedName("held_items") val heldItems: List<HeldItemsResponse>?,
    @SerializedName("id") val id: Int?,
    @SerializedName("is_default") val isDefault: Boolean?,
    @SerializedName("location_area_encounters") val locationAreaEncounters: String?,
    @SerializedName("moves") val moves: List<MovesResponse>?,
    @SerializedName("name") val name: String?,
    @SerializedName("order") val order: Int?,
    @SerializedName("past_types") val pastTypes: List<PastTypeResponse>?,
    @SerializedName("species") val species: ListItemResponse?,
    @SerializedName("sprites") val sprites: SpritesResponse?,
    @SerializedName("types") val types: List<TypesResponse>?,
    @SerializedName("stats") val stats: List<StatsResponse>?,
    @SerializedName("weight") val weight: Int?
)