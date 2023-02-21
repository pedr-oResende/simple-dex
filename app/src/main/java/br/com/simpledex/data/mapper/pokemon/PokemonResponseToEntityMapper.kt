package br.com.simpledex.data.mapper.pokemon

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.remote.model.ability.AbilitiesResponse
import br.com.simpledex.data.remote.model.form.FormsResponse
import br.com.simpledex.data.remote.model.game.GameIndicesResponse
import br.com.simpledex.data.remote.model.game.other.HeldItemsResponse
import br.com.simpledex.data.remote.model.game.other.SpeciesResponse
import br.com.simpledex.data.remote.model.game.other.SpritesResponse
import br.com.simpledex.data.remote.model.move.MovesResponse
import br.com.simpledex.data.remote.model.pokemon.PokemonResponse
import br.com.simpledex.data.remote.model.stat.StatsResponse
import br.com.simpledex.data.remote.model.type.PastTypeResponse
import br.com.simpledex.data.remote.model.type.TypesResponse
import br.com.simpledex.domain.model.ability.Abilities
import br.com.simpledex.domain.model.form.Forms
import br.com.simpledex.domain.model.game.GameIndices
import br.com.simpledex.domain.model.game.other.HeldItems
import br.com.simpledex.domain.model.game.other.Species
import br.com.simpledex.domain.model.game.other.Sprites
import br.com.simpledex.domain.model.move.Moves
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.model.stat.Stats
import br.com.simpledex.domain.model.type.PastType
import br.com.simpledex.domain.model.type.Types

class PokemonResponseToEntityMapper(
    private val abilitiesResponseToEntityMapper: NullableListMapper<AbilitiesResponse, Abilities>,
    private val formsResponseToEntityMapper: NullableListMapper<FormsResponse, Forms>,
    private val gameIndicesResponseToEntityMapper: NullableListMapper<GameIndicesResponse, GameIndices>,
    private val movesResponseToEntityMapper: NullableListMapper<MovesResponse, Moves>,
    private val typesResponseToEntityMapper: NullableListMapper<TypesResponse, Types>,
    private val statsResponseToEntityMapper: NullableListMapper<StatsResponse, Stats>,
    private val heldItemsResponseToEntityMapper: NullableListMapper<HeldItemsResponse, HeldItems>,
    private val pastTypesResponseToEntityMapper: NullableListMapper<PastTypeResponse, PastType>,
    private val speciesResponseToEntityMapper: Mapper<SpeciesResponse, Species>,
    private val spritesResponseToEntityMapper: Mapper<SpritesResponse, Sprites>,
) : Mapper<PokemonResponse, Pokemon> {
    override fun map(input: PokemonResponse): Pokemon = input.run {
        Pokemon(
            id = id,
            name = name,
            height = height,
            weight = weight,
            isDefault = isDefault,
            order = order,
            locationAreaEncounters = locationAreaEncounters,
            baseExperience = baseExperience,
            heldItems = heldItemsResponseToEntityMapper.map(heldItems),
            pastTypes = pastTypesResponseToEntityMapper.map(pastTypes),
            abilities = abilitiesResponseToEntityMapper.map(abilities),
            forms = formsResponseToEntityMapper.map(forms),
            gameIndices = gameIndicesResponseToEntityMapper.map(gameIndices),
            moves = movesResponseToEntityMapper.map(moves),
            types = typesResponseToEntityMapper.map(types),
            stats = statsResponseToEntityMapper.map(stats),
            species = species?.let { speciesResponseToEntityMapper.map(species) },
            sprites = sprites?.let { spritesResponseToEntityMapper.map(sprites) }
        )
    }
}