package dev.pelotasplus.radiofm.domain.model

data class RadioStation(
    val id: Long,
    val slug: String,
    val name: String,
    val streamUrl: String,
//    val logoUrl: String,
//    val novelty: Boolean,
//    val sponsored: Boolean,
//    val premium: Boolean,
//    val top: Boolean,
//    val contentType: String // MUSIC
)
