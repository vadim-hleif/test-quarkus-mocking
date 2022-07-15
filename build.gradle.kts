import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version KOTLIN_VERSION
    kotlin("plugin.allopen") version KOTLIN_VERSION

    id("io.quarkus") version QUARKUS_VERSION

    java
    idea
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    // Quarkus
    implementation(enforcedPlatform("io.quarkus:quarkus-universe-bom:$QUARKUS_VERSION"))

    // Build
    implementation("io.quarkus:quarkus-arc")

    // Kotlin
    implementation("io.quarkus:quarkus-kotlin")

    // Tests
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.quarkus:quarkus-junit5-mockito")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

    testImplementation("io.kotest:kotest-assertions-core-jvm:$KOTEST_VERSION")
    testImplementation("io.kotest:kotest-assertions-json:$KOTEST_VERSION")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    kotlinOptions.javaParameters = true
}
tasks.withType<Test> { useJUnitPlatform() }

allOpen {
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

idea.module {
    isDownloadJavadoc = true
    isDownloadSources = true
}
