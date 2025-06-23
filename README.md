# WebMorph Logging Core

This project provides a preconfigured [Log4j2](https://logging.apache.org/log4j/) setup as a reusable artifact to be
consumed by other modules in the **WebMorph** ecosystem or external Spring-based applications.

<p align="center">
<img alt="License" src="https://img.shields.io/github/license/web-morph/logger">
<a href="https://docs.gradle.org/8.14/release-notes.html"><img src="https://img.shields.io/badge/Gradle-8.14-brightgreen.svg?colorB=469C00&logo=gradle"></a>
<a href="https://repo.jyraf.com/service/rest/v1/search/assets/download?sort=version&repository=maven-releases&maven.groupId=com.github.webmorph&maven.artifactId=logger&maven.extension=jar&maven.classifier=" target="_blank"><img alt="Download" src="https://img.shields.io/nexus/r/com.github.webmorph/logger?server=https%3A%2F%2Frepo.jyraf.com"></a>
</p>

---

## 📦 Installation

⚙️ Gradle (Kotlin DSL – build.gradle.kts)

```kts
repositories {
    maven("https://repo.jyraf.com/repository/maven-public/")
}

dependencies {
    implementation("com.github.webmorph:logger:<version>")
}
```

⚙️ Gradle (Groovy DSL – build.gradle)

```groovy
repositories {
    maven {
        url 'https://repo.jyraf.com/repository/maven-public/'
    }
}

dependencies {
    implementation "com.github.webmorph:logger:<version>"
}
```

### ⚠️ Note: you must exclude its default spring logging setup to avoid conflicts with Log4j2!

⚙️ Gradle (Kotlin DSL – build.gradle.kts)

```kts
configurations {
    all {
        exclude(module = "spring-boot-starter-logging")
        exclude(group = "ch.qos.logback")
    }
}
```

⚙️ Gradle (Groovy DSL – build.gradle)

```groovy
configurations {
    all {
        exclude module: 'spring-boot-starter-logging'
        exclude group: 'ch.qos.logback'
    }
}
```
