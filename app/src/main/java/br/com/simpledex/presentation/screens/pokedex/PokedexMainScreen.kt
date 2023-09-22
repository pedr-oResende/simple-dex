package br.com.simpledex.presentation.screens.pokedex

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.simpledex.commom.extension.isScrolledToTheEnd
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.presentation.compose.animation.FadeAnimation
import br.com.simpledex.presentation.compose.components.state.error.DefaultErrorScreen
import br.com.simpledex.presentation.compose.components.state.loading.DefaultLoadingScreen
import br.com.simpledex.presentation.compose.widgets.top_bar.*
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexEvents
import org.koin.androidx.compose.getViewModel

@Composable
fun PokedexMainScreen(
    navHostController: NavHostController,
    viewModel: PokedexViewModel = getViewModel()
) {
    val homeUI = viewModel.pokedexUI.value
    Scaffold(
        topBar = {
            FadeAnimation(visible = homeUI.isSearching) {
                SearchTopBar(
                    searchText = homeUI.searchText,
                    placeholderText = "Nome do pokémon",
                    onClearClick = { viewModel.onEvent(PokedexEvents.CloseSearchBar) },
                    onSearchTextChanged = { viewModel.onEvent(PokedexEvents.SearchTextChanged(it)) }
                )
            }
            FadeAnimation(visible = !homeUI.isSearching) {
                TopBar(
                    title = "National dex",
                    onBackPressed = { navHostController.popBackStack() },
                    actions = {
                        TopBarIcon(
                            onClick = { viewModel.onEvent(PokedexEvents.OpenSearchBar) },
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
                        PokedexScreen(
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
fun PokedexScreen(
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
        state = state,
        contentPadding = PaddingValues(16.dp)
    ) {
        items(pokemonList) { pokemon ->
            PokemonItem(
                modifier = Modifier
                    .fillMaxWidth()
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