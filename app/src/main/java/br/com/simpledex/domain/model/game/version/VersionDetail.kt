package br.com.simpledex.domain.model.game.version

import br.com.simpledex.domain.model.commom.ListItem

data class VersionDetail(
    val rarity: Int?,
    val version: ListItem?
)