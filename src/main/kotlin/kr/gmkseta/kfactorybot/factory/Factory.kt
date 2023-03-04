package kr.gmkseta.kfactorybot.factory

import kr.gmkseta.kfactorybot.builder.Builder
import kotlin.reflect.KClass

object Factory {
    private val builders = mutableMapOf<KClass<*>, Builder<*>>()

    fun <T: Any>define(kClass: KClass<T>, lambda: Builder<T>.() -> Unit) : Builder<T> {
        val builder = Builder(kClass)
        lambda(builder)

        builders[kClass] = builder
        return builder
    }

    fun create(kClass: KClass<*>, type: String? = "default"): Any {
        return builders[kClass]!!.create(type)
    }
}