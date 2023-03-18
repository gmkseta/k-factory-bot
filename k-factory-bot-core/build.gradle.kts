import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

dependencies {
    testImplementation(kotlin("test"))

}

publishing {
    publications {
        create<MavenPublication>("core") {
            from(components["kotlin"])
            artifactId = "k-factory-bot-core"
            groupId = groupId
            version = version

            pom {
                name.set("KFactoryBot Core")
                description.set("Kotlin Factory Bot Core Library")
                url.set("https://github.com/gmkseta/k-factory-bot")
                scm {
                    url.set("https://github.com/gmkseta/k-factory-bot.git")
                }
            }
        }
    }
}
