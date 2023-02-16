package br.com.simpledex.presentation.model

import androidx.compose.ui.graphics.Color
import br.com.simpledex.R

enum class PokemonType(stringRes: Int, color: Color, icon: Int) {
    NORMAL(R.string.normal_type, Color(0xFF828282), R.drawable.normal_type_icon),
    FIRE(R.string.fire_type, Color(0xFFE6613C), R.drawable.fire_type_icon),
    FIGHTING(R.string.fighting_type, Color(0xFFE6921B), R.drawable.fighting_type_icon),
    WATER(R.string.water_type, Color(0xFF2C9BE3), R.drawable.water_type_icon),
    FLYING(R.string.flying_type, Color(0xFF75ADD2), R.drawable.flying_type_icon),
    GRASS(R.string.grass_type, Color(0xFF419A34), R.drawable.grass_type_icon),
    POISON(R.string.poison_type, Color(0xFF9553CD), R.drawable.poison_type_icon),
    GROUND(R.string.ground_type, Color(0xFFA67439), R.drawable.ground_type_icon),
    ROCK(R.string.rock_type, Color(0xFFABA782), R.drawable.rock_type_icon),
    ICE(R.string.ice_type, Color(0xFF45CACA), R.drawable.ice_type_icon),
    BUG(R.string.ice_type, Color(0xFFA1A123), R.drawable.bug_type_icon),
    DRAGON(R.string.dragon_type, Color(0xFF5670BE), R.drawable.dragon_type_icon),
    GHOST(R.string.ghost_type, Color(0xFF6F4371), R.drawable.ghost_type_icon),
    DARK(R.string.dark_type, Color(0xFF4E4545), R.drawable.dark_type_icon),
    STEEL(R.string.steel_type, Color(0xFF6BAFCA), R.drawable.steel_type_icon),
    FAIRY(R.string.fairy_type, Color(0xFFE38EE3), R.drawable.fairy_type_icon),
    NONE(0, Color.White, 0)
}