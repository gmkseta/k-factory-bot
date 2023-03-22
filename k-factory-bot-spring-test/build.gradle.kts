
plugins {
    kotlin("jvm")
    id("org.springframework.boot") version "2.7.7"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("plugin.jpa") version "1.8.10"
}

repositories {
    mavenCentral()
}
dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":k-factory-bot-core"))
    implementation("org.hibernate:hibernate-core")
    implementation("javax.persistence:javax.persistence-api")
    testImplementation("com.h2database:h2:1.4.200")
}


//kotlin.sourceSets {
//    test {
//        ou
//    }
//}



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