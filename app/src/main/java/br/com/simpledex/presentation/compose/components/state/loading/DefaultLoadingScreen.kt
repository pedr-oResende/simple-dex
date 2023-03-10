package br.com.simpledex.presentation.compose.components.state.loading

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DefaultLoadingScreen(
    color: Color = MaterialTheme.colorScheme.primary,
    text: String? = null
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            CircularProgressIndicator(color = color)
            if (text != null) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = text, style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}