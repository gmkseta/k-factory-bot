package kr.gmkseta.kfactorybot.builder

import kotlin.reflect.KClass

class Builder<T: Any>(
    private val kClass: KClass<T>
){
    private val instances = mutableMapOf<String, T>()

    fun create(type: String? = "default"): T{
        return instances[type] ?: throw IllegalArgumentException("No instance defined for type $type")
    }

    fun add(type: String, lambda: Builder<T>.() -> T) {
        instances[type] = lambda()
    }

    fun trait(type: String, lambda: T.() -> T) {
        instances[type] = instances["default"]!!.lambda()
    }
}