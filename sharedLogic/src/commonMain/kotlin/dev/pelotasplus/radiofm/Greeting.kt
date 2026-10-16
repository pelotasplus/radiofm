package dev.pelotasplus.radiofm

import org.koin.core.annotation.Single

@Single
class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return sayHello(platform.name)
    }
}