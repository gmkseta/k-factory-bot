package io.github.gmkseta.kfactorybot.spring

import io.github.gmkseta.kfactorybot.core.FactoryBot
import io.github.gmkseta.kfactorybot.spring.factories.postFactory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HibernateDataSaverTest{




    @Test
    fun test(){
        val post = postFactory.create()


        print(post)
    }
}