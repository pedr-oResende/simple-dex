package br.com.simpledex.domain.use_case.pokedex

import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.repository.PokedexRepository
import kotlinx.coroutines.flow.Flow

class GetPokedexListUseCase(
    private val repository: PokedexRepository
) {

    operator fun invoke(limit: Int = 30, offset: Int = 0): Flow<List<ListItem>> {
        return repository.getPokedexList(limit, offset)
    }

}