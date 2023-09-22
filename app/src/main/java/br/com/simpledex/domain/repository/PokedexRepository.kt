package br.com.simpledex.domain.repository

import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.pokedex.Pokedex
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {

    fun getPokedexList(limit: Int, offset: Int): Flow<List<ListItem>>

    fun getPokedex(id: Int): Flow<Pokedex>

}