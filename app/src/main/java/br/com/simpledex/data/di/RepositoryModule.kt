package br.com.simpledex.data.di

import br.com.simpledex.commom.mapper.NullableListMapperImpl
import br.com.simpledex.data.local.data_sources.PokemonLocalDataSourceImpl
import br.com.simpledex.data.mapper.base.ListItemResponseToEntityMapper
import br.com.simpledex.data.mapper.base.PagedListResponseToPagedListMapper
import br.com.simpledex.data.mapper.pokedex.PokedexResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.LocalPokemonToEntityMapper
import br.com.simpledex.data.mapper.pokemon.PokemonResponseToEntityMapper
import br.com.simpledex.data.mapper.pokemon.PokemonToLocalEntityMapper
import br.com.simpledex.data.remote.data_sources.pokedex.PokedexRemoteDataSourceImpl
import br.com.simpledex.data.remote.data_sources.pokemon.PokemonRemoteDataSourceImpl
import br.com.simpledex.data.repository.PokedexRepositoryImpl
import br.com.simpledex.data.repository.PokemonRepositoryImpl
import br.com.simpledex.domain.repository.PokedexRepository
import br.com.simpledex.domain.repository.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<PokemonRepository> {
        PokemonRepositoryImpl(
            remoteDataSource = PokemonRemoteDataSourceImpl(get()),
            localDataSource = PokemonLocalDataSourceImpl(get()),
            pokemonListResponseToEntityMapper = PagedListResponseToPagedListMapper(
                listMapper = NullableListMapperImpl(
                    mapper = get<ListItemResponseToEntityMapper>()
                )
            ),
            pokemonResponseToEntityMapper = get<PokemonResponseToEntityMapper>(),
            pokemonToLocalEntityMapper = get<PokemonToLocalEntityMapper>(),
            localPokemonToEntityMapper = get<LocalPokemonToEntityMapper>(),
            localListPokemonToEntityMapper = NullableListMapperImpl(
                mapper = get<LocalPokemonToEntityMapper>()
            )
        )
    }

    single<PokedexRepository> {
        PokedexRepositoryImpl(
            remoteDataSource = PokedexRemoteDataSourceImpl(get()),
            pokedexListResponseToEntityMapper = PagedListResponseToPagedListMapper(
                listMapper = NullableListMapperImpl(
                    mapper = get<ListItemResponseToEntityMapper>()
                )
            ),
            pokedexResponseToEntityMapper = get<PokedexResponseToEntityMapper>()
        )
    }

}