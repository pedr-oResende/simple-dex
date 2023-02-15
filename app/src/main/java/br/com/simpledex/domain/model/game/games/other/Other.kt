package br.com.simpledex.domain.model.game.games.other

import br.com.simpledex.domain.model.game.games.DreamWorld
import br.com.simpledex.domain.model.game.games.Home

data class Other(
    val dreamWorld: DreamWorld?,
    val home: Home?,
    val officialArtwork: OfficialArtwork?
)