package dev.pelotasplus.radiofm.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("dev.pelotasplus.radiofm")
class AppModule {

    @Single
    fun provideJson() = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Single
    fun provideHttpClient(json: Json, logger: Logger) =
        HttpClient {
            install(ContentNegotiation) {
                json(json)
            }
            install(Logging) {
                this.logger = logger
                level = LogLevel.ALL
            }
        }
}
