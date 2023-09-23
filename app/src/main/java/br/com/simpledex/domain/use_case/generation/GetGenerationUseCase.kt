package br.com.simpledex.domain.use_case.generation

import br.com.simpledex.domain.model.generation.Generation
import br.com.simpledex.domain.repository.GenerationRepository
import kotlinx.coroutines.flow.Flow

class GetGenerationUseCase(
    private val repository: GenerationRepository
) {

    operator fun invoke(name: String): Flow<Generation> {
        return repository.getGeneration(name)
    }

}