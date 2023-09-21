package br.com.simpledex.domain.model.pokemon

import br.com.simpledex.domain.model.ability.Abilities
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.game.GameIndices
import br.com.simpledex.domain.model.game.other.*
import br.com.simpledex.domain.model.move.Moves
import br.com.simpledex.domain.model.stat.Stats
import br.com.simpledex.domain.model.type.PastType
import br.com.simpledex.domain.model.type.Types

data class Pokemon(
    val id: Int?,
    val name: String?,
    val sprites: Sprites?,
    val baseExperience: Int?,
    val height: Int?,
    val isDefault: Boolean?,
    val locationAreaEncounters: String?,
    val order: Int?,
    val pastTypes: List<PastType>?,
    val weight: Int?,
    val heldItems: List<HeldItems>?,
    val abilities: List<Abilities>?,
    val forms: List<ListItem>?,
    val gameIndices: List<GameIndices>?,
    val moves: List<Moves>?,
    val species: ListItem?,
    val stats: List<Stats>?,
    val types: List<Types>?
)