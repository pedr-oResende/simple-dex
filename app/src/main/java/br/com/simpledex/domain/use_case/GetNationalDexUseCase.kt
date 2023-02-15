package br.com.simpledex.domain.use_case

import br.com.simpledex.domain.model.base.PagedList
import br.com.simpledex.domain.model.pokemon.PokemonList
import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetNationalDexUseCase(
    private val repository: PokemonRepository
) {
    operator fun invoke(): Flow<PagedList<PokemonList>> {
        return repository.getPokemonList(limit = 10, offset = 0)
    }
}