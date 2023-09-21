package br.com.simpledex.domain.use_case.pokedex

import br.com.simpledex.domain.model.pokedex.Pokedex
import br.com.simpledex.domain.repository.PokedexRepository
import kotlinx.coroutines.flow.Flow

class GetPokedexUseCase(
    private val repository: PokedexRepository
) {

    private fun invoke(id: Int): Flow<Pokedex> {
        return repository.getPokedex(id)
    }

}