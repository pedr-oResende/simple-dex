package br.com.simpledex.domain.model.game.other

import br.com.simpledex.domain.model.game.version.VersionDetail

data class HeldItems(
    val item: HeldItem?,
    val versionDetails: List<VersionDetail>?
)