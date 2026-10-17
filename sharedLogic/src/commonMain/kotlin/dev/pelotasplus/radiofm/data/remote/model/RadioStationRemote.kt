package dev.pelotasplus.radiofm.data.remote.model

import dev.pelotasplus.radiofm.domain.model.RadioStation
import kotlinx.serialization.Serializable

@Serializable
data class RadioStationRemote(
    val id: Long,
    val slug: String,
    val name: String,
    val streamUrl: String,
    val logoUrl: String,
    val top: Boolean,
)

fun RadioStationRemote.toDomain() =
    RadioStation(
        id = this.id,
        slug = this.slug,
        name = this.name,
        streamUrl = this.streamUrl,
        logoUrl = this.logoUrl,
        top = this.top
    )
