package br.com.simpledex.domain.model.pokedex

class Pokedex(
    val id: Int,
    val isMainSeries: Boolean,
    val name: String,
    val pokemonEntries: List<PokedexEntry>,
)