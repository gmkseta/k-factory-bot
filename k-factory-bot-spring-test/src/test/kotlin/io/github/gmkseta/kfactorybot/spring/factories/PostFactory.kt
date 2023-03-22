package io.github.gmkseta.kfactorybot.spring.factories

import io.github.gmkseta.kfactorybot.core.FactoryBot
import io.github.gmkseta.kfactorybot.spring.HibernateDataSaver


val test = FactoryBot.setDataSaver(HibernateDataSaver())

val postFactory = FactoryBot.define(Post::class){
    add("default") {
        Post(
            title = "title",
            content = "content"
        )
    }

    add("empty title"){
        Post(
            title = "",
            content = "content"
        )
    }
}