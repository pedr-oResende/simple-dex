package br.com.simpledex.presentation.screens.nav_host

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.simpledex.presentation.compose.navigation.*

@Composable
fun NavHostScreen(onBackPressedDispatcher: OnBackPressedDispatcher) {
    val navHostController = rememberNavController()
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navHostController,
        startDestination = Screens.Home.route,
        builder = {
            home(
                navHostController = navHostController
            )
            generation(
                navHostController = navHostController
            )
            pokemonDetail(
                navHostController = navHostController,
                onBackPressedDispatcher = onBackPressedDispatcher
            )
        }
    )
}