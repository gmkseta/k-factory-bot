package io.github.gmkseta.kfactorybot.core.persistence

interface FactoryDataSaver<T> {
    fun save(instance: T)
}
