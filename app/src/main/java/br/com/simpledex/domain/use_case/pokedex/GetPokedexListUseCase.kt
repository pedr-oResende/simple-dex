package br.com.simpledex.domain.use_case.pokedex

import br.com.simpledex.domain.model.base.PagedList
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.repository.PokedexRepository
import kotlinx.coroutines.flow.Flow

class GetPokedexListUseCase(
    private val repository: PokedexRepository
) {

    private fun invoke(limit: Int, offset: Int): Flow<PagedList<ListItem>> {
        return repository.getPokedexList(limit, offset)
    }

}