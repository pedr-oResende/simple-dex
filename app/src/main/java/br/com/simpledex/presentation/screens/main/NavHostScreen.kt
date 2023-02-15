package br.com.simpledex.presentation.screens.main

import androidx.activity.OnBackPressedDispatcher
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import br.com.simpledex.presentation.compose.navigation.Screens
import br.com.simpledex.presentation.compose.navigation.home
import br.com.simpledex.presentation.compose.navigation.pokemonDetail
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavHostScreen(onBackPressedDispatcher: OnBackPressedDispatcher) {
    val navHostController = rememberAnimatedNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    AnimatedNavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navHostController,
        startDestination = Screens.Home.route,
        builder = {
            home(
                navHostController = navHostController,
                snackbarHostState = snackbarHostState
            )
            pokemonDetail(
                navHostController = navHostController,
                onBackPressedDispatcher = onBackPressedDispatcher,
                snackbarHostState = snackbarHostState
            )
        }
    )
}