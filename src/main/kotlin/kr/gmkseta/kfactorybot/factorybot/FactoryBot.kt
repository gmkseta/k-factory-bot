package kr.gmkseta.kfactorybot.factorybot

import kr.gmkseta.kfactorybot.builder.Builder
import kotlin.reflect.KClass

object FactoryBot {
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