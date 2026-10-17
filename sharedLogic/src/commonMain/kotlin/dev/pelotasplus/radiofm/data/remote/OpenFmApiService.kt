package dev.pelotasplus.radiofm.data.remote

import dev.pelotasplus.radiofm.data.remote.model.RadioStationRemote
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Singleton

@Singleton
class OpenFmApiService(
    private val httpClient: HttpClient
) {
    suspend fun getStations(): List<RadioStationRemote> {
        return httpClient.get("https://open.fm/api/radio/stations")
            .body<Map<String, RadioStationRemote>>()
            .values
            .toList()
    }

}
