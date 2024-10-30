plugins {
    `java-library`
    `maven-publish`
    id("org.jetbrains.kotlin.jvm") version "1.9.22"

}

group = "me.yeezhi.taboolib"
version = "1.0.6"
var taboolibVersion = "6.1.2-beta10"
repositories {
    mavenLocal()
    maven("https://maven.aliyun.com/repository/public")
    maven("https://repo.tabooproject.org/repository/releases/")
}

dependencies {
    compileOnly("com.google.code.gson:gson:2.10.1")
    compileOnly("io.izzel.taboolib:common:$taboolibVersion")
    compileOnly("io.izzel.taboolib:module-chat:$taboolibVersion")
    compileOnly("io.izzel.taboolib:module-configuration:$taboolibVersion")
    compileOnly("io.izzel.taboolib:platform-bukkit:$taboolibVersion")
    compileOnly("io.izzel.taboolib:common-platform-api:$taboolibVersion")
    compileOnly("io.izzel.taboolib:common-util:$taboolibVersion")
    compileOnly("io.izzel.taboolib:common-env:$taboolibVersion")
    compileOnly("io.izzel.taboolib:module-bukkit-util:$taboolibVersion")
    compileOnly("io.izzel.taboolib:module-bukkit-hook:$taboolibVersion")
    compileOnly("ink.ptms:nms-all:1.0.0")
    compileOnly("ink.ptms.core:v12004:12004-minimize:mapped")
    compileOnly("ink.ptms.core:v12004:12004-minimize:universal")
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "$group"
            version = version
            from(components["java"])
        }
    }
    repositories {
        maven {
            val mavenRepoUrl = System.getenv("CODING_ARTIFACTS_REPO_URL")
            val mavenUsername = System.getenv("CODING_ARTIFACTS_GRADLE_USERNAME")
            val mavenPassword = System.getenv("CODING_ARTIFACTS_GRADLE_PASSWORD")

            url = uri(mavenRepoUrl)
            credentials {
                username = mavenUsername.toString()
                password = mavenPassword.toString()
            }
        }
    }
}
kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}