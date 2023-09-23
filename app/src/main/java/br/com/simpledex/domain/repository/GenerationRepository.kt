package br.com.simpledex.domain.repository

import br.com.simpledex.domain.model.generation.Generation
import kotlinx.coroutines.flow.Flow

interface GenerationRepository {

    fun getGeneration(name: String): Flow<Generation>

}