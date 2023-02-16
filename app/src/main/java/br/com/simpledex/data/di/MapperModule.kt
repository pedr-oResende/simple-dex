package br.com.simpledex.data.di

import br.com.simpledex.commom.mapper.NullableListMapperImpl
import br.com.simpledex.data.mapper.ability.AbilitiesResponseToEntityMapper
import br.com.simpledex.data.mapper.ability.AbilityResponseToEntityMapper
import br.com.simpledex.data.mapper.form.FormsResponseToEntityMapper
import br.com.simpledex.data.mapper.game.games.GenerationVIIResponseToEntityMapper
import br.com.simpledex.data.mapper.game.games.UltraSunUltraMoonResponseToEntityMapper
import br.com.simpledex.data.mapper.game.other.OfficialArtworkResponseToEntityMapper
import br.com.simpledex.data.mapper.game.other.OtherResponseToEntityMapper
import br.com.simpledex.data.mapper.game.other.SpeciesResponseToEntityMapper
import br.com.simpledex.data.mapper.game.other.SpritesResponseToEntityMapper
import br.com.simpledex.data.mapper.game.other.indice.GameIndicesResponseToEntityMapper
import br.com.simpledex.data.mapper.game.version.VersionGroupDetailsResponseToEntityMapper
import br.com.simpledex.data.mapper.game.version.VersionGroupResponseToEntityMapper
import br.com.simpledex.data.mapper.game.version.VersionResponseToEntityMapper
import br.com.simpledex.data.mapper.game.version.VersionsResponseToEntityMapper
import br.com.simpledex.data.mapper.icons.IconsResponseToEntityMapper
import br.com.simpledex.data.mapper.move.MoveLearnMethodResponseToEntityMapper
import br.com.simpledex.data.mapper.move.MoveResponseToEntityMapper
import br.com.simpledex.data.mapper.move.MovesResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.PokemonListResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.PokemonResponseToEntityMapper
import br.com.simpledex.data.mapper.stat.StatResponseToEntityMapper
import br.com.simpledex.data.mapper.stat.StatsResponseToEntityMapper
import br.com.simpledex.data.mapper.type.TypesResponseToEntityMapper
import org.koin.dsl.module

val mapperModule = module {

    single { PokemonListResponseToEntityMapper() }

    single { AbilityResponseToEntityMapper() }

    single { FormsResponseToEntityMapper() }

    single { VersionResponseToEntityMapper() }

    single { MoveResponseToEntityMapper() }

    single { VersionGroupResponseToEntityMapper() }

    single { MoveLearnMethodResponseToEntityMapper() }

    single { StatResponseToEntityMapper() }

    single { SpeciesResponseToEntityMapper() }

    single { OfficialArtworkResponseToEntityMapper() }

    single { IconsResponseToEntityMapper() }

    single { UltraSunUltraMoonResponseToEntityMapper() }

    single { TypesResponseToEntityMapper() }

    single {
        VersionGroupDetailsResponseToEntityMapper(
            moveLearnMethodResponseToEntityMapper = get<MoveLearnMethodResponseToEntityMapper>(),
            versionGroupResponseToEntityMapper = get<VersionGroupResponseToEntityMapper>()
        )
    }

    single {
        VersionsResponseToEntityMapper(
            generationVIIResponseToEntityMapper = get<GenerationVIIResponseToEntityMapper>()
        )
    }

    single {
        OtherResponseToEntityMapper(
            officialArtworkResponseToEntityMapper = get<OfficialArtworkResponseToEntityMapper>()
        )
    }

    single {
        SpritesResponseToEntityMapper(
            otherResponseToEntityMapper = get<OtherResponseToEntityMapper>(),
            versionsResponseToEntityMapper = get<VersionsResponseToEntityMapper>()
        )
    }

    single {
        GenerationVIIResponseToEntityMapper(
            iconsResponseToEntityMapper = get<IconsResponseToEntityMapper>(),
            ultraSunUltraMoonResponseToEntityMapper = get<UltraSunUltraMoonResponseToEntityMapper>()
        )
    }

    single {
        StatsResponseToEntityMapper(
            statResponseToEntityMapper = get<StatResponseToEntityMapper>()
        )
    }

    single {
        GameIndicesResponseToEntityMapper(
            versionResponseToEntityMapper = get<VersionResponseToEntityMapper>()
        )
    }

    single {
        AbilitiesResponseToEntityMapper(
            abilityResponseToEntityMapper = get<AbilityResponseToEntityMapper>()
        )
    }

    single {
        MovesResponseToEntityMapper(
            moveResponseToEntityMapper = get<MoveResponseToEntityMapper>(),
            versionGroupDetailsResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<VersionGroupDetailsResponseToEntityMapper>()
            )
        )
    }

    single {
        PokemonResponseToEntityMapper(
            abilitiesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<AbilitiesResponseToEntityMapper>()
            ),
            formsResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<FormsResponseToEntityMapper>()
            ),
            gameIndicesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<GameIndicesResponseToEntityMapper>()
            ),
            movesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<MovesResponseToEntityMapper>()
            ),
            typesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<TypesResponseToEntityMapper>()
            ),
            statsResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<StatsResponseToEntityMapper>()
            ),
            speciesResponseToEntityMapper = get<SpeciesResponseToEntityMapper>(),
            spritesResponseToEntityMapper = get<SpritesResponseToEntityMapper>()
        )
    }

}