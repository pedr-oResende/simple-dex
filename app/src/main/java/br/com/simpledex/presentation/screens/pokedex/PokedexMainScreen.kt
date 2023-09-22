package br.com.simpledex.presentation.screens.pokedex

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.simpledex.commom.extension.isScrolledToTheEnd
import br.com.simpledex.domain.model.pokemon.Pokemon
import br.com.simpledex.domain.model.pokemon.dummyPokemons
import br.com.simpledex.presentation.compose.animation.FadeAnimation
import br.com.simpledex.presentation.compose.components.state.error.DefaultErrorScreen
import br.com.simpledex.presentation.compose.components.state.loading.DefaultLoadingScreen
import br.com.simpledex.presentation.compose.navigation.Screens
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme
import br.com.simpledex.presentation.compose.widgets.top_bar.*
import br.com.simpledex.presentation.model.PokemonType
import br.com.simpledex.presentation.model.StateUI
import br.com.simpledex.presentation.screens.pokedex.ui.PokedexEvents
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun PokedexMainScreen(
    navHostController: NavHostController,
    viewModel: PokedexViewModel = getViewModel {
        parametersOf(navHostController.currentBackStackEntry?.arguments?.getString(Screens.Pokedex.argumentKey)?.toInt() ?: 0)
    }
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
                    title = homeUI.pokedex?.name.orEmpty(),
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
                            onItemClick = { },
                            pokemonList = homeUI.filteredPokemonList,
                            isLoading = viewModel.loadMoreState.collectAsState().value.loading(),
                            isAllPokemonsLoaded = viewModel.isAllPokemonsLoaded(),
                            loadMorePokemon = { viewModel.loadMorePokemon() }
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
    onItemClick: () -> Unit,
    loadMorePokemon: () -> Unit,
    pokemonList: List<Pokemon>,
    isLoading: Boolean,
    isAllPokemonsLoaded: Boolean
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
                name = pokemon.getFormattedName(),
                sprite = pokemon.sprites?.frontDefault,
                types = pokemon.types?.map { it.type ?: PokemonType.NONE },
                onCLick = { onItemClick() }
            )
        }
        if (isAllPokemonsLoaded.not()) {
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
}

@Preview
@Composable
fun PokedexScreenPrev() {
    SimpleDexTheme {
        PokedexScreen(
            onItemClick = {},
            loadMorePokemon = {},
            pokemonList = dummyPokemons,
            isLoading = false,
            isAllPokemonsLoaded = true
        )
    }
}