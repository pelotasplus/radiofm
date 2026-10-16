package dev.pelotasplus.radiofm

import android.app.Application
import dev.pelotasplus.radiofm.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class RadioFmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@RadioFmApplication)
            androidLogger()
        }
    }
}
