# Kotlin test library

Objective of this library is to create a boilerplate for publishing libraries to Jitpack or local Maven repository.

## Modifications to `build.gradle.kts` file

### Plugins

```kotlin
plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.7.10"

    // Apply the java-library plugin for API and implementation separation.
    id("java-library")
    id("maven-publish")
}
```

### JAVA toolchain

```kotlin
// Apply a specific Java toolchain to ease working on different environments.
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
```

### Publishing

```kotlin
publishing {
    publications {
        create<MavenPublication>("Maven") {
            groupId = "com.george"
            artifactId = rootProject.name
            version = "0.1"
            from(components["java"])
        }
    }
}
```
