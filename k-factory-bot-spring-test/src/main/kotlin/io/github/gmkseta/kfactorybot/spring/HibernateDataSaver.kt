package io.github.gmkseta.kfactorybot.spring

import io.github.gmkseta.kfactorybot.core.persistence.FactoryDataSaver
import javax.persistence.EntityManager
import javax.persistence.Persistence


class HibernateDataSaver : FactoryDataSaver<Any> {
    private val entityManager: EntityManager

    init {
        val entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit")
        entityManager = entityManagerFactory.createEntityManager()
    }

    override fun save(instance: Any) {
        entityManager.transaction.begin()
        entityManager.persist(instance)
        entityManager.transaction.commit()
    }
}