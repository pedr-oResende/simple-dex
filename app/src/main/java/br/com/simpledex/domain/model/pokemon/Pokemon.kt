package br.com.simpledex.domain.model.pokemon

import br.com.simpledex.domain.model.ability.Abilities
import br.com.simpledex.domain.model.form.Forms
import br.com.simpledex.domain.model.game.GameIndices
import br.com.simpledex.domain.model.game.games.other.Species
import br.com.simpledex.domain.model.game.games.other.Sprites
import br.com.simpledex.domain.model.game.games.other.Stats
import br.com.simpledex.domain.model.game.games.other.Types
import br.com.simpledex.domain.model.move.Moves

data class Pokemon(
    val id: Int?,
    val name: String?,
    val abilities: List<Abilities>?,
    val baseExperience: Int?,
    val forms: List<Forms>?,
    val gameIndices: List<GameIndices>?,
    val height: Int?,
    val heldItems: List<String>?,
    val isDefault: Boolean?,
    val locationAreaEncounters: String?,
    val moves: List<Moves>?,
    val order: Int?,
    val pastTypes: List<String>?,
    val species: Species?,
    val sprites: Sprites?,
    val stats: List<Stats>?,
    val types: List<Types>?,
    val weight: Int?
)