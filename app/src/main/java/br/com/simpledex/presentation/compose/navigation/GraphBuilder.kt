
package br.com.simpledex.presentation.compose.navigation

import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.*
import androidx.navigation.compose.composable
import br.com.simpledex.presentation.screens.home.HomeMainScreen
import br.com.simpledex.presentation.screens.generation.GenerationMainScreen

fun NavGraphBuilder.home(
    navHostController: NavHostController
) {
    composable(
        route = Screens.Home.route
    ) {
        HomeMainScreen(navHostController = navHostController)
    }
}


fun NavGraphBuilder.generation(
    navHostController: NavHostController
) {
    composable(
        route = Screens.Generation.route,
        arguments = listOf(navArgument(Screens.Generation.argumentKey) {
            type = NavType.StringType
            nullable = false
        })
    ) {
        GenerationMainScreen(navHostController = navHostController)
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