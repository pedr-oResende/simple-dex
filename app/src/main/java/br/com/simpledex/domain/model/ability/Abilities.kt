package br.com.simpledex.domain.model.ability

import br.com.simpledex.domain.model.commom.ListItem

data class Abilities(
    val ability: ListItem?,
    val isHidden: Boolean?,
    val slot: Int?
)