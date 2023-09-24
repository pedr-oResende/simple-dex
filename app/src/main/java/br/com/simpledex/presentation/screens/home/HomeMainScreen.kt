package br.com.simpledex.presentation.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import br.com.simpledex.domain.model.generation.Gen
import br.com.simpledex.presentation.compose.navigation.Screens
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme
import br.com.simpledex.presentation.compose.widgets.top_bar.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMainScreen(
    navHostController: NavHostController
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(title = "Generations", scrollBehavior = scrollBehavior)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize()
        ) {
            val generation = Gen.values().dropLast(1)
            HomeScreen(
                generations = generation,
                onItemClick = { id ->
                    navHostController.navigate(Screens.Generation.routeWithArgument(id))
                }
            )
        }
    }
}

@Composable
fun HomeScreen(
    generations: List<Gen>,
    onItemClick: (id: String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(generations) { generation ->
            GenerationItem(
                modifier = Modifier.fillMaxSize(fraction = 0.8f),
                name = generation.title,
                backgroundImage = generation.image,
                onClick = {
                    onItemClick(generation.serverName)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    SimpleDexTheme {
        HomeScreen(
            generations = Gen.values().dropLast(1),
            onItemClick = {}
        )
    }
}