package br.com.simpledex.domain.model.game.games

import br.com.simpledex.data.model.game.games.GoldResponse

data class GenerationII(
    val crystal: Crystal?,
    val gold: GoldResponse?,
    val silver: Silver?
)