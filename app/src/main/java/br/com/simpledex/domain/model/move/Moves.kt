package br.com.simpledex.domain.model.move

import br.com.simpledex.domain.model.game.version.VersionGroupDetails

data class Moves(
    val move: Move?,
    val versionGroupDetails: List<VersionGroupDetails>
)

