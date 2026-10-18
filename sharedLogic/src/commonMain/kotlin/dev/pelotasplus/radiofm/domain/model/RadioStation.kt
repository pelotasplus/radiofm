package dev.pelotasplus.radiofm.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class RadioStation(
    val id: Long,
    val slug: String,
    val name: String,
    val streamUrl: String,
    val logoUrl: String,
    val top: Boolean,
//    val novelty: Boolean,
//    val sponsored: Boolean,
//    val premium: Boolean,
//    val contentType: String // MUSIC
)
