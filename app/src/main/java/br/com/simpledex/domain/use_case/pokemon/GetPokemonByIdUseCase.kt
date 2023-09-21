package br.com.simpledex.domain.use_case.pokemon

import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonByIdUseCase(
    private val repository: PokemonRepository
) {
    operator fun invoke(id: Int): Flow<Pokemon> {
        return repository.getPokemonById(id)
    }
}