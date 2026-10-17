package dev.pelotasplus.radiofm.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class PlaylistRemote(
    val id: Long,
    val slug: String,
    val name: String,
    val items: List<Long>,
    val totalElements: Long,
)
