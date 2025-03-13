plugins {
    application
}

group = "io.github.canary-prism"
version = "1.0.0"

application {
    mainModule = "canaryprism.electronconfig"
    mainClass = "canaryprism.electronconfig.Main"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}