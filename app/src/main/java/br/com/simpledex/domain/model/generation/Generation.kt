package br.com.simpledex.domain.model.generation

import br.com.simpledex.domain.model.commom.ListItem

data class Generation(
    val id: Int? = null,
    val gen: Gen = Gen.None,
    val pokemonSpecies: List<ListItem> = emptyList()
)

enum class Gen(val serverName: String, name: String, val image: String) {
    One(
        serverName = "generation-i",
        name = "gen one",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"
    ),
    Two(
        serverName = "generation-ii",
        name = "gen two",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/197.png"
    ),
    Three(
        serverName = "generation-iii",
        name = "gen three",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/384.png"
    ),
    Four(
        serverName = "generation-iv",
        name = "gen four",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/445.png"
    ),
    Five(
        serverName = "generation-v",
        name = "gen five",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/635.png"
    ),
    Six(
        serverName = "generation-vi",
        name = "gen six",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/657.png"
    ),
    Seven(
        serverName = "generation-vii",
        name = "gen seven",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/722.png"
    ),
    Eight(
        serverName = "generation-viii",
        name = "gen eight",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/888.png"
    ),
    Nine(
        serverName = "generation-ix",
        name = "gen nine",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/959.png"
    ),
    None(
        serverName = "",
        name = "",
        image = ""
    )
}