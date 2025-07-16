# WebMorph Logging Core

This project provides a preconfigured [Log4j2](https://logging.apache.org/log4j/) setup as a reusable artifact to be
consumed by other modules in the **WebMorph** ecosystem or external Spring-based applications.

<p align="center">
<img alt="License" src="https://img.shields.io/github/license/web-morph/logger">
<a href="https://docs.gradle.org/8.14/release-notes.html"><img src="https://img.shields.io/badge/Gradle-8.14-brightgreen.svg?colorB=469C00&logo=gradle"></a>
<a href="https://repo.billmarssoft.com/api/maven/latest/file/releases/com/github/webmorph/logger?extension=jar" target="_blank"><img alt="Download" src="https://repo.billmarssoft.com/api/badge/latest/releases/com/github/webmorph/logger"></a>
<a href="https://repo.billmarssoft.com/javadoc/releases/com/github/webmorph/logger/latest" target="_blank"><img alt="Download" src="https://img.shields.io/badge/javadoc-latest-red"></a>
</p>

---

## 📦 Installation

⚙️ Gradle (Kotlin DSL – build.gradle.kts)

```kts
repositories {
    maven("https://repo.billmarssoft.com/public/")
}

dependencies {
    implementation("com.github.webmorph:logger:<version>")
}
```

⚙️ Gradle (Groovy DSL – build.gradle)

```groovy
repositories {
    maven {
        url 'https://repo.billmarssoft.com/public/'
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
