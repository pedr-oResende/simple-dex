package br.com.simpledex.domain.use_case

import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonNameFromLocalUseCase(
    private val repository: PokemonRepository
) {
    operator fun invoke(): Flow<List<String>> {
        return repository.getPokemonNameFromLocal()
    }
}