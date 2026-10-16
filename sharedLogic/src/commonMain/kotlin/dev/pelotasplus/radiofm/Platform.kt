package dev.pelotasplus.radiofm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform