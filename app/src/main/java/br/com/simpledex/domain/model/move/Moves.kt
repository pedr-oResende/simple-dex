package br.com.simpledex.domain.model.move

import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.game.version.VersionGroupDetails

data class Moves(
    val move: ListItem?,
    val versionGroupDetails: List<VersionGroupDetails>
)

