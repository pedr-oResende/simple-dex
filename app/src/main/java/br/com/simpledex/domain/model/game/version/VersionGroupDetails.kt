package br.com.simpledex.domain.model.game.version

import br.com.simpledex.domain.model.move.MoveLearnMethod

data class VersionGroupDetails(
    val levelLearnedAt: Int?,
    val moveLearnMethod: MoveLearnMethod?,
    val versionGroup: VersionGroup?
)