package br.com.simpledex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.simpledex.data.remote.util.preferences.PreferencesWrapper
import br.com.simpledex.domain.model.pokemon.PokemonList
import br.com.simpledex.domain.use_case.GetNationalDexUseCase
import br.com.simpledex.domain.use_case.GetPokemonByIdUseCase
import br.com.simpledex.presentation.compose.theme.SimpleDexTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleDexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        PreferencesWrapper.getInstance()?.clearPreferences()
    }
}
