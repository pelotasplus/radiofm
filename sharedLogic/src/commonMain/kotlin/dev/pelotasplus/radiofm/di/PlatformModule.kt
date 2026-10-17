package dev.pelotasplus.radiofm.di

import io.ktor.client.plugins.logging.Logger
import org.koin.core.annotation.Single

expect class PlatformModule {
    @Single
    fun httpLogger(): Logger
}
