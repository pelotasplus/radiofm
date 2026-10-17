package dev.pelotasplus.radiofm.data.repository

import dev.pelotasplus.radiofm.data.remote.OpenFmApiService
import dev.pelotasplus.radiofm.domain.model.RadioStation
import org.koin.core.annotation.Single

@Single
class RadioRepository(
    private val apiService: OpenFmApiService
) {
    suspend fun getStations(): List<RadioStation> {
        return apiService.getStations()
            .map {
                RadioStation(
                    id = it.id,
                    slug = it.slug,
                    name = it.name,
                    streamUrl = it.streamUrl)
            }
    }
}
