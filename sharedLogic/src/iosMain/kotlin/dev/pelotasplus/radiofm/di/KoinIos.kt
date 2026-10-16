package dev.pelotasplus.radiofm.di

import dev.pelotasplus.radiofm.data.repository.RadioRepository
import org.koin.mp.KoinPlatform

fun initKoinIos() = initKoin()

fun radioRepository(): RadioRepository = KoinPlatform.getKoin().get()
