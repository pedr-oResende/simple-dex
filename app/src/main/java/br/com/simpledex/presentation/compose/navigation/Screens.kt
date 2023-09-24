package br.com.simpledex.presentation.compose.navigation

sealed class Screens(route: String, argumentKey: String) : ScreenNavOperations(route, argumentKey) {

    data object Home : Screens(
        route = "home?home_argument={home_argument}",
        argumentKey = "home_argument"
    )

    data object Generation : Screens(
        route = "pokedex?pokedex_argument={pokedex_argument}",
        argumentKey = "pokedex_argument"
    )

    data object PokemonDetail : Screens(
        route = "pokemon_detail",
        argumentKey = "pokemon_detail_argument"
    )

}