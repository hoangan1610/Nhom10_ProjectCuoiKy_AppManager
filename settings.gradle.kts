pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        ////neumorphism
        maven { url = uri("https://jitpack.io") }

    }
}

rootProject.name = "Nhom10_ProjectCuoiKy"
include(":app")
