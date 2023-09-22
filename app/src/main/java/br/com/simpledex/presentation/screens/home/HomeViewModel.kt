package br.com.simpledex.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.use_case.pokedex.GetPokedexListUseCase
import br.com.simpledex.presentation.model.StateUI
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPokedexListUseCase: GetPokedexListUseCase
) : ViewModel() {

    private val _pokedexListResponse = MutableStateFlow<StateUI<List<ListItem>>>(StateUI.Idle())
    val pokedexListResponse: StateFlow<StateUI<List<ListItem>>> = _pokedexListResponse

    init {
        loadPokedexList()
    }

    private fun loadPokedexList() {
        viewModelScope.launch {
            getPokedexListUseCase().onStart {
                _pokedexListResponse.emit(StateUI.Processing())
            }.catch {
                _pokedexListResponse.emit(StateUI.Error(it.message.orEmpty()))
            }.collect { pokedexList ->
                _pokedexListResponse.emit(StateUI.Processed(pokedexList))
            }
        }
    }

    fun refresh() = loadPokedexList()

}