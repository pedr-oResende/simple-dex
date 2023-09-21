package br.com.simpledex.domain.use_case

import br.com.simpledex.domain.model.base.PagedList
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetNationalDexUseCase(
    private val repository: PokemonRepository
) {
    operator fun invoke(limit: Int = 15, offset: Int = 0): Flow<PagedList<ListItem>> {
        return repository.getPokemonList(limit = limit, offset = offset)
    }
}