package br.com.simpledex.domain.model.game.other

import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.game.version.VersionDetail

data class HeldItems(
    val item: ListItem?,
    val versionDetails: List<VersionDetail>?
)