var javaVersion = 8;
group = "com.github.webmorph"
version = "1.0.3"

plugins {
    id("java-library")
    id("maven-publish")
    id("io.spring.dependency-management").version("1.1.7")
    id("io.github.gradle-nexus.publish-plugin").version("1.1.0")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Logs
    api("org.apache.logging.log4j:log4j-api:2.24.3")
    api("org.apache.logging.log4j:log4j-core:2.24.3")
    api("org.apache.logging.log4j:log4j-slf4j2-impl:2.24.3")
}

tasks {
    register<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }
    register<Jar>("javadocJar") {
        archiveClassifier.set("javadoc")
        from(javadoc)
    }
    javadoc {
        options.encoding = "UTF-8"
        options.memberLevel = JavadocMemberLevel.PUBLIC
        isFailOnError = false
    }
    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(javaVersion)
    }
    build {
        dependsOn("sourcesJar", "javadocJar")
    }
    jar {
        enabled = true
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])
        }
    }
    repositories {
        maven {
            name = "BillmarsSoft"
            url = uri("https://repo.billmarssoft.com/releases/")
            credentials {
                username = System.getenv("REPOSITORY_USERNAME")
                password = System.getenv("REPOSITORY_PASSWORD")
            }
        }
    }
}