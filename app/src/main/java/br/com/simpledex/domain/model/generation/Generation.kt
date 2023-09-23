package br.com.simpledex.domain.model.generation

import br.com.simpledex.domain.model.commom.ListItem

data class Generation(
    val id: Int? = null,
    val gen: Gen = Gen.None,
    val pokemonSpecies: List<ListItem> = emptyList(),
    val versionGroups: List<ListItem> = emptyList()
)

enum class Gen(val serverName: String, val title: String, val image: String) {
    One(
        serverName = "generation-i",
        title = "gen one",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"
    ),
    Two(
        serverName = "generation-ii",
        title = "gen two",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/197.png"
    ),
    Three(
        serverName = "generation-iii",
        title = "gen three",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/384.png"
    ),
    Four(
        serverName = "generation-iv",
        title = "gen four",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/445.png"
    ),
    Five(
        serverName = "generation-v",
        title = "gen five",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/635.png"
    ),
    Six(
        serverName = "generation-vi",
        title = "gen six",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/658.png"
    ),
    Seven(
        serverName = "generation-vii",
        title = "gen seven",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/722.png"
    ),
    Eight(
        serverName = "generation-viii",
        title = "gen eight",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/888.png"
    ),
    Nine(
        serverName = "generation-ix",
        title = "gen nine",
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/959.png"
    ),
    None(
        serverName = "",
        title = "",
        image = ""
    );

    companion object {
        fun getByName(name: String?) = Gen.values().first {
                it.serverName == name
            }
    }
}