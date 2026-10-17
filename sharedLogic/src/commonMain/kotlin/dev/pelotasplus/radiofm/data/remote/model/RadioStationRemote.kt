package dev.pelotasplus.radiofm.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class RadioStationRemote(
    val id: Long,
    val slug: String,
    val name: String,
    val streamUrl: String,
)
