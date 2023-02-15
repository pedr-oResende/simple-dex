package br.com.simpledex.presentation.compose.navigation

sealed class Screens(route: String, argumentKey: String) : ScreenNavOperations(route, argumentKey) {

    object Home : Screens(
        route = "home?home_argument={home_argument}",
        argumentKey = "home_argument"
    )

    object PokemonDetail : Screens(
        route = "pokemon_detail",
        argumentKey = "pokemon_detail_argument"
    )

}