
package br.com.simpledex.presentation.compose.navigation

import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.simpledex.presentation.screens.home.HomeMainScreen
import br.com.simpledex.presentation.screens.pokedex.PokedexMainScreen

fun NavGraphBuilder.home(
    navHostController: NavHostController
) {
    composable(
        route = Screens.Home.route
    ) {
        HomeMainScreen(navHostController = navHostController)
    }
}


fun NavGraphBuilder.pokedex(
    navHostController: NavHostController
) {
    composable(
        route = Screens.Pokedex.route
    ) {
        PokedexMainScreen(navHostController = navHostController)
    }
}

fun NavGraphBuilder.pokemonDetail(
    navHostController: NavHostController,
    onBackPressedDispatcher: OnBackPressedDispatcher
) {
    composable(
        route = Screens.PokemonDetail.route
    ) {

    }
}