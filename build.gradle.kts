
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.8.10" apply false
    id("com.gradle.plugin-publish") version "1.1.0"
    id("maven-publish")
}

allprojects {
    group = "io.github.gmkseta"
    version = "0.0.3"

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation(kotlin("test"))
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    tasks.test {
        useJUnitPlatform()
    }
}

gradlePlugin{
    plugins{
        create("kFactoryBot"){
            id = "io.github.gmkseta.k-factory-bot"
            implementationClass = "io.github.gmkseta.kfactorybot.core.FactoryBot"
            displayName = "KFactoryBot"
            description = "Kotlin Factory Bot"
        }
    }
}

pluginBundle {
    website = "https://github.com/gmkseta/k-factory-bot"
    vcsUrl = "https://github.com/gmkseta/k-factory-bot"
    tags = listOf("test")
    plugins
}