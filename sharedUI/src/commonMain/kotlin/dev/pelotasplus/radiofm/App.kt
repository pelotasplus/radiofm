package dev.pelotasplus.radiofm

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.pelotasplus.radiofm.data.repository.RadioRepository
import dev.pelotasplus.radiofm.domain.model.RadioStation
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

import radiofm.sharedui.generated.resources.Res
import radiofm.sharedui.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val greeting = koinInject<Greeting>()
        val repository = koinInject<RadioRepository>()
        var stations by remember { mutableStateOf<List<RadioStation>>(emptyList()) }

        LaunchedEffect(Unit) {
            stations = repository.getStations()
        }

        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                Column(
                    modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: ${greeting.greet()}")
                    stations.forEach { station ->
                        Text(station.name)
                    }
                }
            }
        }
    }
}
