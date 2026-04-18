import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    kotlin("jvm")
    id("com.gradleup.shadow")
}

// ---- gradle.properties 에서 한 번에 불러오기 ----
val pluginGroup        = property("group") as String
val pluginVersion      = property("version") as String
val pluginName         = property("pluginName") as String
val pluginDescription  = property("pluginDescription") as String
val pluginAuthor       = property("pluginAuthor") as String
val pluginMainClass    = property("pluginMainClass") as String
val mcVersion          = property("mcVersion") as String
val mcApiVersion       = property("mcApiVersion") as String
val ktVersion          = property("ktVersion") as String
val javaVersion        = (property("javaVersion") as String).toInt()

// 패키지 규칙: <group>.<pluginName(lowercase)>.<MainClass>
val pluginPackage  = "$pluginGroup.${pluginName.lowercase()}"
val pluginMainFQN  = "$pluginPackage.$pluginMainClass"

group       = pluginGroup
version     = pluginVersion
description = pluginDescription

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:$mcVersion-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$ktVersion")
}

tasks.named<ShadowJar>("shadowJar") {
    archiveBaseName.set(pluginName)
    archiveVersion.set(pluginVersion)
    archiveClassifier.set("")
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand(
            "pluginName"        to pluginName,
            "pluginVersion"     to pluginVersion,
            "pluginDescription" to pluginDescription,
            "pluginAuthor"      to pluginAuthor,
            "pluginMain"        to pluginMainFQN,
            "apiVersion"        to mcApiVersion,
        )
    }
}
