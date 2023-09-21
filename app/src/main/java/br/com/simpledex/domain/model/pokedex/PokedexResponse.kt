package br.com.simpledex.domain.model.pokedex

import br.com.simpledex.domain.model.commom.ListItem

class Pokedex(
    val id: Int,
    val isMainSeries: Boolean,
    val name: String,
    val pokemonEntries: List<ListItem>,
)