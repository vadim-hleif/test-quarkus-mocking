plugins {
    kotlin("jvm") version KOTLIN_VERSION

    id("io.quarkus") version QUARKUS_VERSION
}

repositories { mavenCentral() }

dependencies {
    // Quarkus
    implementation(enforcedPlatform("io.quarkus:quarkus-universe-bom:$QUARKUS_VERSION"))

    // Kotlin
    implementation("io.quarkus:quarkus-kotlin")

    // Tests
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.quarkiverse.mockk:quarkus-junit5-mockk:1.1.1")
}