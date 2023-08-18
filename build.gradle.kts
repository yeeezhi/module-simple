plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.2" apply false

}

group = "me.qingshou.taboolib"
version = "1.0.0"
val taboolibVersion = "6.0.12-13"
repositories {
    mavenLocal()
    maven("https://maven.aliyun.com/repository/public")
    maven("https://repo.tabooproject.org/repository/releases/")
}

dependencies {
    implementation ("cn.hutool:hutool-all:5.8.20")
    compileOnly("com.alibaba.fastjson2:fastjson2:2.0.35")
    compileOnly("com.alibaba.fastjson2:fastjson2-kotlin:2.0.39")

    compileOnly("io.izzel.taboolib:common:$taboolibVersion")
    compileOnly("io.izzel.taboolib:module-chat:$taboolibVersion")
    compileOnly("io.izzel.taboolib:module-configuration:$taboolibVersion")
    compileOnly("io.izzel.taboolib:platform-bukkit:$taboolibVersion")
    compileOnly(fileTree("libs"))
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "$group"

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