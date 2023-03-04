import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    id("com.gradle.plugin-publish") version "1.1.0"

}

group = "kr.gmkseta"
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
            groupId = "kr.gmkseta"
            version = "0.0.1"
        }
    }
}

gradlePlugin{
    plugins {
        create("kFactoryBot") {
            id = "kr.gmkseta.k-factory-bot"
            implementationClass = "kr.gmkseta.kfactorybot.KFactoryBotPlugin"
            displayName = "KFactoryBot"
            description = "Kotlin Factory Bot"
        }
    }
}