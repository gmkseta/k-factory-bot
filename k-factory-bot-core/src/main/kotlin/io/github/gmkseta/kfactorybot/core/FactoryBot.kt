package io.github.gmkseta.kfactorybot.core

import io.github.gmkseta.kfactorybot.core.builder.Builder
import io.github.gmkseta.kfactorybot.core.persistence.FactoryDataSaver
import kotlin.reflect.KClass

object FactoryBot {
    private val builders = mutableMapOf<KClass<*>, Builder<*>>()
    private var dataSaver: FactoryDataSaver<*>? = null

    fun <T: Any>define(kClass: KClass<T>, lambda: Builder<T>.() -> Unit) : Builder<T> {
        val builder = Builder(kClass)
        lambda(builder)

        builders[kClass] = builder
        return builder
    }

    fun <T : Any> setDataSaver(saver: FactoryDataSaver<T>) {
        dataSaver = saver
    }

    fun <T : Any> create(kClass: KClass<T>, type: String? = "default"): T {
        val instance = builders[kClass]!!.create(type) as T
        (dataSaver as FactoryDataSaver<T>).save(instance)

        return instance
    }


}