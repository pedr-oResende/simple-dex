package br.com.simpledex.domain.use_case

import br.com.simpledex.domain.model.Pokemon
import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonByIdUseCase(
    private val repository: PokemonRepository
) {
    operator fun invoke(id: Int): Flow<Pokemon> {
        return repository.getPokemonById(id)
    }
}