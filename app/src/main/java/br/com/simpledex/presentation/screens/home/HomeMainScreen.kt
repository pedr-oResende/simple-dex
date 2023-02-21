package br.com.simpledex.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.simpledex.commom.extension.isScrolledToTheEnd
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.presentation.compose.components.state.error.DefaultErrorScreen
import br.com.simpledex.presentation.compose.components.state.loading.DefaultLoadingScreen
import br.com.simpledex.presentation.compose.widgets.top_bar.SearchTopBar
import br.com.simpledex.presentation.compose.widgets.top_bar.TopBar
import br.com.simpledex.presentation.compose.widgets.top_bar.TopBarIcon
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.home.ui.HomeEvents
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMainScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = getViewModel()
) {
    val homeUI = viewModel.homeUI.value
    Scaffold(
        topBar = {
            if (homeUI.isSearching) {
                SearchTopBar(
                    searchText = homeUI.searchText,
                    placeholderText = "Nome do pokémon",
                    onClearClick = { viewModel.onEvent(HomeEvents.CloseSearchBar) },
                    onSearchTextChanged = { viewModel.onEvent(HomeEvents.SearchTextChanged(it)) }
                )
            } else {
                TopBar(
                    title = "National dex",
                    actions = {
                        TopBarIcon(
                            onClick = { viewModel.onEvent(HomeEvents.OpenSearchBar) },
                            imageVector = Icons.Default.Search
                        )
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize()
        ) {
            viewModel.pokemonListResponse.collectAsState().value.let { response ->
                when (response) {
                    is StateUI.Error -> DefaultErrorScreen(message = response.message)
                    is StateUI.Idle -> Unit
                    is StateUI.Processed -> {
                        PokemonListScreen(
                            navHostController = navHostController,
                            pokemonList = homeUI.filteredPokemonList,
                            isLoading = viewModel.loadMoreResponse.collectAsState().value.loading(),
                            loadMorePokemon = {
                                viewModel.loadMorePokemon()
                            }
                        )
                    }
                    is StateUI.Processing -> DefaultLoadingScreen()
                }
            }
        }
    }
}

@Composable
fun PokemonListScreen(
    navHostController: NavHostController,
    pokemonList: List<Pokemon>,
    isLoading: Boolean,
    loadMorePokemon: () -> Unit
) {
    val state = rememberLazyListState()
    if (state.isScrolledToTheEnd() and isLoading.not())
        loadMorePokemon()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = state
    ) {
        item { Spacer(modifier = Modifier) }
        items(pokemonList) { pokemon ->
            PokemonItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(MaterialTheme.shapes.large)
                    .clickable { },
                pokemon = pokemon
            )
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
            ) {
                if (isLoading)
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}