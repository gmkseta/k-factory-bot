package io.github.gmkseta.kfactorybot.core.builder

import io.github.gmkseta.kfactorybot.core.persistence.FactoryDataSaver
import kotlin.reflect.KClass

class Builder<T: Any>(
    private val kClass: KClass<T>,
    private var dataSaver: FactoryDataSaver<Any>? = null
){
    private val instances = mutableMapOf<String, T>()

    fun create(type: String? = "default"): T{
        val instance = instances[type] ?: throw IllegalArgumentException("Type $type not found")
        dataSaver?.save(instance)
        return instance
    }

    fun add(type: String, lambda: Builder<T>.() -> T) {
        instances[type] = lambda()
    }

    fun trait(type: String, lambda: T.() -> T) {
        instances[type] = instances["default"]!!.lambda()
    }
}