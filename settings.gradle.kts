pluginManagement {
    val ktVersion: String by settings
    val shadowJarVersion: String by settings

    repositories {
        gradlePluginPortal()
    }

    plugins {
        kotlin("jvm") version ktVersion
        id("com.gradleup.shadow") version shadowJarVersion
    }
}

rootProject.name = settings.extra.properties["pluginName"] as String? ?: "PluginTemplate"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://oss.sonatype.org/content/groups/public/")
    }
}
