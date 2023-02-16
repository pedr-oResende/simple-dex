package br.com.simpledex.domain.model.pokemon

import br.com.simpledex.domain.model.ability.Abilities
import br.com.simpledex.domain.model.form.Forms
import br.com.simpledex.domain.model.game.GameIndices
import br.com.simpledex.domain.model.game.games.other.Species
import br.com.simpledex.domain.model.game.games.other.Sprites
import br.com.simpledex.domain.model.stat.Stats
import br.com.simpledex.domain.model.type.Types
import br.com.simpledex.domain.model.move.Moves

data class Pokemon(
    val id: Int?,
    val name: String?,
    val baseExperience: Int?,
    val height: Int?,
    val heldItems: List<String>?,
    val isDefault: Boolean?,
    val locationAreaEncounters: String?,
    val order: Int?,
    val pastTypes: List<String>?,
    val weight: Int?,
    val abilities: List<Abilities>?,
    val forms: List<Forms>?,
    val gameIndices: List<GameIndices>?,
    val moves: List<Moves>?,
    val species: Species?,
    val sprites: Sprites?,
    val stats: List<Stats>?,
    val types: List<Types>?
)