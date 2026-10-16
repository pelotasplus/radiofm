package dev.pelotasplus.radiofm.data.repository

import dev.pelotasplus.radiofm.domain.model.RadioStation
import org.koin.core.annotation.Single

@Single
class RadioRepository {

    fun getStations(): List<RadioStation> {
        return listOf(
            RadioStation("Radio Zet"),
            RadioStation("Radio ESKA"),
            RadioStation("RMF24"),
        )
    }
}
