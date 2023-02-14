package br.com.simpledex.data.model.pokemon

import br.com.simpledex.*
import br.com.simpledex.data.model.*
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("abilities") val abilities: List<AbilitiesResponse>?,
    @SerializedName("base_experience") val baseExperience: Int?,
    @SerializedName("forms") val forms: List<FormsResponse>?,
    @SerializedName("game_indices") val gameIndices: List<GameIndicesResponse>?,
    @SerializedName("height") val height: Int?,
    @SerializedName("held_items") val heldItems: List<String>?,
    @SerializedName("id") val id: Int?,
    @SerializedName("is_default") val isDefault: Boolean?,
    @SerializedName("location_area_encounters") val locationAreaEncounters: String?,
    @SerializedName("moves") val moves: List<MovesResponse>?,
    @SerializedName("name") val name: String?,
    @SerializedName("order") val order: Int?,
    @SerializedName("past_types") val pastTypes: List<String>?,
    @SerializedName("species") val species: SpeciesResponse?,
    @SerializedName("sprites") val sprites: SpritesResponse?,
    @SerializedName("stats") val stats: List<StatsResponse>?,
    @SerializedName("types") val types: List<TypesResponse>?,
    @SerializedName("weight") val weight: Int?
)