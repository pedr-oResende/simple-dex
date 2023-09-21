package br.com.simpledex.domain.model.game.version

import br.com.simpledex.domain.model.commom.ListItem

data class VersionGroupDetails(
    val levelLearnedAt: Int?,
    val moveLearnMethod: ListItem?,
    val versionGroup: ListItem?
)