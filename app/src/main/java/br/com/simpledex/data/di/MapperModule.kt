package br.com.simpledex.data.di

import br.com.simpledex.commom.mapper.NullableListMapperImpl
import br.com.simpledex.data.mapper.ability.AbilitiesResponseToEntityMapper
import br.com.simpledex.data.mapper.ability.AbilityResponseToEntityMapper
import br.com.simpledex.data.mapper.form.FormsResponseToEntityMapper
import br.com.simpledex.data.mapper.game.indice.GameIndicesResponseToEntityMapper
import br.com.simpledex.data.mapper.game.version.VersionResponseToEntityMapper
import br.com.simpledex.data.mapper.move.MoveResponseToEntityMapper
import br.com.simpledex.data.mapper.move.MovesResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.PokemonListResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.PokemonResponseToEntityMapper
import org.koin.dsl.module

val mapperModule = module {

    single { PokemonListResponseToEntityMapper() }

    single { AbilityResponseToEntityMapper() }

    single { FormsResponseToEntityMapper() }

    single { VersionResponseToEntityMapper() }

    single {
        GameIndicesResponseToEntityMapper(
            versionResponseToEntityMapper = get()
        )
    }

    single {
        AbilitiesResponseToEntityMapper(
            abilityResponseToEntityMapper = get()
        )
    }

    single {
        GameIndicesResponseToEntityMapper(
            versionResponseToEntityMapper = get()
        )
    }

    single { MoveResponseToEntityMapper() }

    single {
        MovesResponseToEntityMapper(
            moveResponseToEntityMapper = get(),
            versionGroupDetailsResponseToEntityMapper = NullableListMapperImpl(

            )
        )
    }

    single {
        PokemonResponseToEntityMapper(
            abilitiesResponseToEntityMapper = NullableListMapperImpl(mapper = get()),
            formsResponseToEntityMapper = NullableListMapperImpl(mapper = get()),
            gameIndicesResponseToEntityMapper = NullableListMapperImpl(mapper = get()),
            movesResponseToEntityMapper =
        )
    }


}