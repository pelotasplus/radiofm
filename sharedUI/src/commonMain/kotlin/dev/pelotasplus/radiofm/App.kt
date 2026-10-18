package dev.pelotasplus.radiofm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.pelotasplus.radiofm.data.repository.RadioRepository
import dev.pelotasplus.radiofm.domain.model.RadioStation
import org.koin.compose.koinInject

sealed interface AppState {
    object Loading : AppState

    data class Success(
        val stations: List<RadioStation>
    ) : AppState

    data class Error(
        val error: Throwable
    ) : AppState
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        var state by remember { mutableStateOf<AppState>(AppState.Loading) }

        val repository = koinInject<RadioRepository>()

        LaunchedEffect(Unit) {
            try {
                val stations = repository.getRadioStations()
                state = AppState.Success(stations)
            } catch (exc: Exception) {
                state = AppState.Error(exc)
            }
        }

        when (val currentState = state) {
            is AppState.Loading -> {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }

            is AppState.Success -> {
                LazyVerticalGrid(
                    modifier = Modifier.safeContentPadding()
                        .fillMaxSize(),
                    columns = GridCells.Adaptive(minSize = 100.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(16.dp),
                ) {
                    items(currentState.stations, key = { it.id }) { station ->
                        StationCard(station)
                    }
                }
            }

            is AppState.Error -> {
                Box(Modifier.fillMaxSize()) {
                    ErrorView(currentState.error.localizedMessage)
                }
            }
        }
    }
}
