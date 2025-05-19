plugins {
    kotlin("jvm") version "2.0.10"
    id("org.jlleitschuh.gradle.ktlint") version "12.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.8.1")
    testImplementation("org.jetbrains.kotlinx", "kotlinx-coroutines-test", "1.8.1")
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.10.2")
    testImplementation("org.assertj", "assertj-core", "3.25.3")
    testImplementation("io.kotest", "kotest-runner-junit5", "5.8.0")
    testImplementation("io.kotest", "kotest-assertions-core", "5.8.0")
    testImplementation("io.mockk:mockk:1.13.8")
}

tasks {
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
    }
}
kotlin {
    jvmToolchain(17)
}
