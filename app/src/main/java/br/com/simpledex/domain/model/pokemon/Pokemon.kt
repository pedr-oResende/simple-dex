package br.com.simpledex.domain.model.pokemon

import br.com.simpledex.domain.model.ability.Abilities
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.game.GameIndices
import br.com.simpledex.domain.model.game.other.HeldItems
import br.com.simpledex.domain.model.game.other.Sprites
import br.com.simpledex.domain.model.move.Moves
import br.com.simpledex.domain.model.stat.Stats
import br.com.simpledex.domain.model.type.PastType
import br.com.simpledex.domain.model.type.Types
import br.com.simpledex.presentation.model.PokemonType

data class Pokemon(
    val id: Int? = null,
    val name: String? = null,
    val sprites: Sprites? = null,
    val baseExperience: Int? = null,
    val height: Int? = null,
    val isDefault: Boolean? = null,
    val locationAreaEncounters: String? = null,
    val order: Int? = null,
    val pastTypes: List<PastType>? = null,
    val weight: Int? = null,
    val heldItems: List<HeldItems>? = null,
    val abilities: List<Abilities>? = null,
    val forms: List<ListItem>? = null,
    val gameIndices: List<GameIndices>? = null,
    val moves: List<Moves>? = null,
    val species: ListItem? = null,
    val stats: List<Stats>? = null,
    val types: List<Types>? = null
) {
    fun getFormattedName(): String {
        return name
            ?.split('-')
            ?.first()
            ?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            }
            .orEmpty()

    }
}

val dummyPokemons = listOf(
    Pokemon(
        name = "Bulbasaur",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.GRASS
            ),
            Types(
                slot = 2,
                type = PokemonType.POISON
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"
        )
    ),
    Pokemon(
        name = "Ivysaur",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.GRASS
            ),
            Types(
                slot = 2,
                type = PokemonType.POISON
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"
        )
    ),
    Pokemon(
        name = "Venusaur",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.GRASS
            ),
            Types(
                slot = 2,
                type = PokemonType.POISON
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"
        )
    ),
    Pokemon(
        name = "Charmander",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.FIRE
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"
        )
    ),
    Pokemon(
        name = "Charmeleon",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.FIRE
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png"
        )
    ),
    Pokemon(
        name = "Charizard",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.FIRE
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png"
        )
    ),
    Pokemon(
        name = "Squirtle",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.WATER
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png"
        )
    ),
    Pokemon(
        name = "Wartortle",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.WATER
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png"
        )
    ),
    Pokemon(
        name = "Blastoise",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.WATER
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png"
        )
    ),
    Pokemon(
        name = "Caterpie",
        types = listOf(
            Types(
                slot = 1,
                type = PokemonType.BUG
            )
        ),
        sprites = Sprites(
            frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png"
        )
    ),
)