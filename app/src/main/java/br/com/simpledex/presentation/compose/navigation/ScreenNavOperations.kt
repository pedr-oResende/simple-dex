package br.com.simpledex.presentation.compose.navigation

import androidx.navigation.NavHostController
import br.com.simpledex.commom.extension.putArgument

sealed class ScreenNavOperations(val route: String, val argumentKey: String) {

    fun <T> routeWithArgument(argument: T?): String {
        return this.route.replace(oldValue = "{$argumentKey}", newValue = argument.toString())
    }

    fun backToHome(navHostController: NavHostController) {
        navHostController.navigate(route = Screens.Home.route) {
            popUpTo(0)
        }
    }

    fun <T> navigateWithArgument(
        navHostController: NavHostController,
        argumentValue: T?
    ) {
        navHostController.currentBackStackEntry?.savedStateHandle?.putArgument(
            key = argumentKey,
            value = argumentValue
        )
        navHostController.navigate(route)
    }

    fun <T> navigateWithListArgument(
        navHostController: NavHostController,
        argumentValue: List<T>?
    ) {
        navHostController.currentBackStackEntry?.savedStateHandle?.putArgument(
            key = argumentKey,
            value = argumentValue
        )
        navHostController.navigate(route)
    }

}