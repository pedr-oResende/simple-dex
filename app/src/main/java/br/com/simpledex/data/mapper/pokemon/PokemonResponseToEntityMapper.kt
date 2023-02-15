package br.com.simpledex.data.mapper.pokemon

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.model.ability.AbilitiesResponse
import br.com.simpledex.data.model.form.FormsResponse
import br.com.simpledex.data.model.game.GameIndicesResponse
import br.com.simpledex.data.model.move.MovesResponse
import br.com.simpledex.data.model.pokemon.PokemonResponse
import br.com.simpledex.domain.model.ability.Abilities
import br.com.simpledex.domain.model.form.Forms
import br.com.simpledex.domain.model.game.GameIndices
import br.com.simpledex.domain.model.move.Moves
import br.com.simpledex.domain.model.pokemon.Pokemon

class PokemonResponseToEntityMapper(
    private val abilitiesResponseToEntityMapper: NullableListMapper<AbilitiesResponse, Abilities>,
    private val formsResponseToEntityMapper: NullableListMapper<FormsResponse, Forms>,
    private val gameIndicesResponseToEntityMapper: NullableListMapper<GameIndicesResponse, GameIndices>,
    private val movesResponseToEntityMapper: NullableListMapper<MovesResponse, Moves>,
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
            abilities = abilitiesResponseToEntityMapper.map(abilities),
            forms = formsResponseToEntityMapper.map(forms),
            gameIndices = gameIndicesResponseToEntityMapper.map(gameIndices),
            heldItems = heldItems,
            pastTypes = pastTypes,
            moves = movesResponseToEntityMapper.map(moves)
        )
    }
}