
plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}
dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":k-factory-bot-core"))
    implementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}





publishing {
    publications {
        create<MavenPublication>("springTest") {
            from(components["kotlin"])
            artifactId = "k-factory-bot-spring-test"
            groupId = groupId
            version = version

            pom {
                name.set("KFactoryBot Spring Test")
                description.set("Kotlin Factory Bot Spring Test Library")
                url.set("https://github.com/gmkseta/k-factory-bot")
                scm {
                    url.set("https://github.com/gmkseta/k-factory-bot.git")
                }
            }
        }
    }
}