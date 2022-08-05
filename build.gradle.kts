import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version KOTLIN_VERSION

    kotlin("plugin.spring") version KOTLIN_VERSION
    kotlin("plugin.jpa") version KOTLIN_VERSION

    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    java
    idea
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

    testImplementation("io.kotest:kotest-assertions-core-jvm:$KOTEST_VERSION")
    testImplementation("io.kotest:kotest-assertions-json:$KOTEST_VERSION")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    kotlinOptions.javaParameters = true
    kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
}
tasks.withType<Test> { useJUnitPlatform() }

idea.module {
    isDownloadJavadoc = true
    isDownloadSources = true
}
