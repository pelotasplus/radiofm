package dev.pelotasplus.radiofm

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import dev.pelotasplus.radiofm.domain.model.RadioStation


@Composable
internal fun StationCard(
    station: RadioStation,
) {
    Card(
        modifier = Modifier.aspectRatio(1f)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize().aspectRatio(1f),
            model = station.logoUrl,
            contentDescription = null
        )
    }
}
