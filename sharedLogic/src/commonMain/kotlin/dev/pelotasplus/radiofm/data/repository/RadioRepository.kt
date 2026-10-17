package dev.pelotasplus.radiofm.data.repository

import dev.pelotasplus.radiofm.data.remote.OpenFmApiService
import dev.pelotasplus.radiofm.data.remote.model.toDomain
import dev.pelotasplus.radiofm.domain.model.RadioStation
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.koin.core.annotation.Single

@Single
class RadioRepository(
    private val apiService: OpenFmApiService
) {
    suspend fun getStations(): List<RadioStation> {
        return apiService.getStations()
            .map { it.toDomain() }
    }

    suspend fun getRadioStations(): List<RadioStation> = coroutineScope {
        val playlistDeferred = async { apiService.getRadioStations() }
        val radioStationsDeferred = async { apiService.getStations().map { it.toDomain() } }

        val playlist = playlistDeferred.await()
        val radioStations = radioStationsDeferred.await()

        val radioStationsById = radioStations.associateBy { it.id }

        playlist.items.mapNotNull { radioStationId -> radioStationsById[radioStationId] }
    }
}
