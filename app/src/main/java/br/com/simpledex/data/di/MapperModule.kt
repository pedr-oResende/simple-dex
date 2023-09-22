package br.com.simpledex.data.di

import br.com.simpledex.commom.mapper.NullableListMapperImpl
import br.com.simpledex.data.mapper.ability.AbilitiesResponseToEntityMapper
import br.com.simpledex.data.mapper.base.ListItemResponseToEntityMapper
import br.com.simpledex.data.mapper.icons.IconsResponseToEntityMapper
import br.com.simpledex.data.mapper.pokedex.PokedexEntryResponseToEntityMapper
import br.com.simpledex.data.mapper.pokedex.PokedexResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.*
import br.com.simpledex.data.mapper.sprites.SpritesResponseToEntityMapper
import br.com.simpledex.data.mapper.stat.StatsResponseToEntityMapper
import br.com.simpledex.data.mapper.type.PastTypeResponseToEntityMapper
import br.com.simpledex.data.mapper.type.TypesResponseToEntityMapper
import org.koin.dsl.module

val mapperModule = module {

    single { IconsResponseToEntityMapper() }

    single { TypesResponseToEntityMapper() }

    single { PokemonToLocalEntityMapper() }

    single { LocalPokemonToEntityMapper() }

    single { ListItemResponseToEntityMapper() }

    single { SpritesResponseToEntityMapper() }

    single {
        PastTypeResponseToEntityMapper(
            generationResponseToEntityMapper = get<ListItemResponseToEntityMapper>(),
            typesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<TypesResponseToEntityMapper>()
            )
        )
    }

    single {
        StatsResponseToEntityMapper(
            statResponseToEntityMapper = get<ListItemResponseToEntityMapper>()
        )
    }

    single {
        AbilitiesResponseToEntityMapper(
            abilityResponseToEntityMapper = get<ListItemResponseToEntityMapper>()
        )
    }

    single {
        PokemonResponseToEntityMapper(
            abilitiesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<AbilitiesResponseToEntityMapper>()
            ),
            listItemResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<ListItemResponseToEntityMapper>()
            ),
            typesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<TypesResponseToEntityMapper>()
            ),
            statsResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<StatsResponseToEntityMapper>()
            ),
            pastTypesResponseToEntityMapper = NullableListMapperImpl(
                mapper = get<PastTypeResponseToEntityMapper>()
            ),
            speciesResponseToEntityMapper = get<ListItemResponseToEntityMapper>(),
            spritesResponseToEntityMapper = get<SpritesResponseToEntityMapper>()
        )
    }

    single {
        PokedexEntryResponseToEntityMapper(
            pokemonResponseToEntityMapper = get<ListItemResponseToEntityMapper>()
        )
    }

    single {
        PokedexResponseToEntityMapper(
            pokemonEntriesResponseToListMapper = NullableListMapperImpl(
                mapper = get<PokedexEntryResponseToEntityMapper>()
            )
        )
    }

}