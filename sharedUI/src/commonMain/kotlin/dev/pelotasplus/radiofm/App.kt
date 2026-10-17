package dev.pelotasplus.radiofm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import dev.pelotasplus.radiofm.data.repository.RadioRepository
import dev.pelotasplus.radiofm.domain.model.RadioStation
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    MaterialTheme {
        val repository = koinInject<RadioRepository>()
        var stations by remember { mutableStateOf<List<RadioStation>>(emptyList()) }

        LaunchedEffect(Unit) {
            stations = repository.getRadioStations()
        }

        LazyVerticalGrid(
            modifier = Modifier.safeContentPadding()
                .fillMaxSize(),
            columns = GridCells.Adaptive(minSize = 100.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(stations, key = { it.id }) { station ->
                StationCard(station)
            }
        }
    }
}
