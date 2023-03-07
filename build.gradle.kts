import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    id("com.gradle.plugin-publish") version "1.1.0"

}

group = "io.github.gmkseta"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifactId = "k-factory-bot"
            groupId = "io.github.gmkseta"
            version = "0.0.1"
            sourceSets["main"].kotlin.srcDirs.forEach {
                artifact(it) {
                    classifier = "sources"
                }
            }
        }
    }
}

gradlePlugin{

    plugins {
        create("FactoryBot") {
            id = "io.github.gmkseta.k-factory-bot"
            implementationClass = "io.github.gmkseta.kfactorybot.factorybot.FactoryBot"
            displayName = "KFactoryBot"
            description = "Kotlin Factory Bot"
        }
    }
}

pluginBundle {
    website = "https://github.com/gmkseta/k-factory-bot"
    vcsUrl = "https://github.com/gmkseta/k-factory-bot"
    tags = listOf("")
}