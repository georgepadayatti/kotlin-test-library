# Kotlin test library

Objective of this library is to create a boilerplate for publishing libraries to Jitpack or local Maven repository.

## Usage

1. Add the JitPack repository to your build file

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

2. Add the dependency

```kotlin
implementation 'com.github.georgepadayatti:kotlin-test-library:0.1'
```

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

## References

1. Building Kotlin Libraries Sample - https://docs.gradle.org/current/samples/sample_building_kotlin_libraries.html (Accessed: 09 March 2024)
