import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.compile.JavaCompile

plugins {
    `java-library`
    `maven-publish`
    id("com.gradleup.shadow") version "9.4.1"
}

group = "me.seetch"
version = "1.0.0"

repositories {
    mavenCentral()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    withSourcesJar()
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(21)
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    implementation("com.google.code.gson:gson:2.10.1")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.named<ShadowJar>("shadowJar") {
    archiveBaseName.set("mlang")
    archiveVersion.set("")
    archiveClassifier.set("")

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    mergeServiceFiles()
}

tasks.named("build") {
    dependsOn("shadowJar")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "me.seetch"
            artifactId = "mlang"
            version = project.version.toString()

            artifact(tasks.named<ShadowJar>("shadowJar")) {
                classifier = null
            }

            artifact(tasks.named("sourcesJar"))
        }
    }

    repositories {
        mavenLocal()
    }
}