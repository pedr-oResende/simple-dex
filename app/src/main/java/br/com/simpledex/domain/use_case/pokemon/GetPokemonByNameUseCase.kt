package br.com.simpledex.domain.use_case.pokemon

import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

class GetPokemonByNameUseCase(
    private val repository: PokemonRepository
) {
    operator fun invoke(name: String): Flow<Pokemon> {
        return repository.getPokemonByName(name)
    }
}