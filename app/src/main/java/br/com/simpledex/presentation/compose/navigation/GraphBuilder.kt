
package br.com.simpledex.presentation.compose.navigation

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import br.com.simpledex.presentation.screens.home.HomeMainScreen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.home(
    navHostController: NavHostController,
    snackbarHostState: SnackbarHostState
) {
    composable(
        route = Screens.Home.route
    ) {
        HomeMainScreen(navHostController = navHostController)
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.pokemonDetail(
    navHostController: NavHostController,
    onBackPressedDispatcher: OnBackPressedDispatcher,
    snackbarHostState: SnackbarHostState
) {
    composable(
        route = Screens.PokemonDetail.route
    ) {

    }
}