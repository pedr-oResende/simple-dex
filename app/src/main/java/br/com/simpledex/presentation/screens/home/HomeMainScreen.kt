package br.com.simpledex.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.simpledex.commom.extension.idFromUrl
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.presentation.compose.components.state.error.DefaultErrorScreen
import br.com.simpledex.presentation.compose.components.state.loading.DefaultLoadingScreen
import br.com.simpledex.presentation.compose.navigation.Screens
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme
import br.com.simpledex.presentation.compose.widgets.top_bar.TopBar
import br.com.simpledex.presentation.model.StateUI
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeMainScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = getViewModel()
) {
    Scaffold(
        topBar = {
            TopBar(title = "Home")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize()
        ) {
            viewModel.pokedexListResponse.collectAsState().value.let { response ->
                when (response) {
                    is StateUI.Error -> DefaultErrorScreen(message = response.message)
                    is StateUI.Idle -> Unit
                    is StateUI.Processed -> {
                        HomeScreen(
                            pokedexList = response.data,
                            onItemClick = { id ->
                                navHostController.navigate(Screens.Pokedex.routeWithArgument(id))
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
fun HomeScreen(
    pokedexList: List<ListItem>,
    onItemClick: (id: Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(pokedexList) { pokedex ->
            PokedexItem(
                modifier = Modifier.fillMaxSize(),
                name = pokedex.name,
                onClick = {
                    onItemClick(pokedex.url.idFromUrl())
                }
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    SimpleDexTheme {
        val regions = listOf("Kanto", "Johto", "Hoenn", "Sinnoh", "Unova", "Kalos", "Alolah", "Galar", "Hisui", "Paldea", "Kitagami")
        HomeScreen(
            pokedexList = regions.map { region ->
                ListItem(
                    name = region,
                    url = ""
                )
            },
            onItemClick = {}
        )
    }
}