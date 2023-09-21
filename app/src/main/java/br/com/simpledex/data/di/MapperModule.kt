package br.com.simpledex.data.di

import br.com.simpledex.commom.mapper.NullableListMapperImpl
import br.com.simpledex.data.mapper.ability.AbilitiesResponseToEntityMapper
import br.com.simpledex.data.mapper.base.ListItemResponseToEntityMapper
import br.com.simpledex.data.mapper.game.games.GenerationVIIResponseToEntityMapper
import br.com.simpledex.data.mapper.game.games.UltraSunUltraMoonResponseToEntityMapper
import br.com.simpledex.data.mapper.game.other.*
import br.com.simpledex.data.mapper.game.other.indice.GameIndicesResponseToEntityMapper
import br.com.simpledex.data.mapper.game.version.*
import br.com.simpledex.data.mapper.icons.IconsResponseToEntityMapper
import br.com.simpledex.data.mapper.move.MovesResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.*
import br.com.simpledex.data.mapper.stat.StatsResponseToEntityMapper
import br.com.simpledex.data.mapper.type.PastTypeResponseToEntityMapper
import br.com.simpledex.data.mapper.type.TypesResponseToEntityMapper
import org.koin.dsl.module

val mapperModule = module {

    single { OfficialArtworkResponseToEntityMapper() }

    single { IconsResponseToEntityMapper() }

    single { UltraSunUltraMoonResponseToEntityMapper() }

    single { TypesResponseToEntityMapper() }

    single { PokemonToLocalEntityMapper() }

    single { LocalPokemonToEntityMapper() }

    single { ListItemResponseToEntityMapper() }

    single {
        PastTypeResponseToEntityMapper(
            generationResponseToEntityMapper = get<ListItemResponseToEntityMapper>(),
            typesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<TypesResponseToEntityMapper>()
            )
        )
    }

    single {
        VersionDetailResponseToEntityMapper(
            versionResponseToEntityMapper = get<ListItemResponseToEntityMapper>()
        )
    }

    single {
        HeldItemsResponseToEntityMapper(
            heldItemResponseToEntityMapper = get<ListItemResponseToEntityMapper>(),
            versionDetailsResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<VersionDetailResponseToEntityMapper>()
            )
        )
    }

    single {
        VersionGroupDetailsResponseToEntityMapper(
            listItemResponseToListItemMapper = get<ListItemResponseToEntityMapper>()
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
            statResponseToEntityMapper = get<ListItemResponseToEntityMapper>()
        )
    }

    single {
        GameIndicesResponseToEntityMapper(
            versionResponseToEntityMapper = get<ListItemResponseToEntityMapper>()
        )
    }

    single {
        AbilitiesResponseToEntityMapper(
            abilityResponseToEntityMapper = get<ListItemResponseToEntityMapper>()
        )
    }

    single {
        MovesResponseToEntityMapper(
            moveResponseToEntityMapper = get<ListItemResponseToEntityMapper>(),
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
                mapper = get<ListItemResponseToEntityMapper>()
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
            heldItemsResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<HeldItemsResponseToEntityMapper>()
            ),
            pastTypesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<PastTypeResponseToEntityMapper>()
            ),
            speciesResponseToEntityMapper = get<ListItemResponseToEntityMapper>(),
            spritesResponseToEntityMapper = get<SpritesResponseToEntityMapper>()
        )
    }

}