package dev.pelotasplus.radiofm.di

import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.Logger
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
actual class PlatformModule {

    @Single
    actual fun httpLogger(): Logger = Logger.ANDROID
}
