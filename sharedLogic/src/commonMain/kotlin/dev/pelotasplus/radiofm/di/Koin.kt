package dev.pelotasplus.radiofm.di

import org.koin.core.annotation.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.plugin.module.dsl.startKoin

@KoinApplication(modules = [AppModule::class])
object KoinApp

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin<KoinApp> {
        includes(config)
    }
}
