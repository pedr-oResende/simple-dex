package br.com.simpledex.presentation.screens.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import br.com.simpledex.domain.use_case.GetNationalDexUseCase
import br.com.simpledex.domain.use_case.GetPokemonByNameUseCase
import br.com.simpledex.domain.use_case.GetPokemonNameFromLocalUseCase
import br.com.simpledex.presentation.MainActivity
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    private val getNationalDexUseCase: GetNationalDexUseCase by inject()

    private val getPokemonByNameUseCase: GetPokemonByNameUseCase by inject()

    private val getPokemonFromLocalUseCase: GetPokemonNameFromLocalUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
        val intent = Intent(this, MainActivity::class.java)
        lifecycleScope.launch {
            getNationalDexUseCase(15, 0).collect { pokemon ->
                pokemon.results.forEach { result ->
                    getPokemonFromLocalUseCase().collect { localPokemon ->
                        if (localPokemon.contains(result.name).not()) {
                            getPokemonByNameUseCase(result.name.orEmpty())
                        }
                    }
                }
                startActivity(intent)
                finish()
            }
        }
    }

}