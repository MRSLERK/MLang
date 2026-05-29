pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.opencollab.dev/main/")
        maven("https://repo.opencollab.dev/maven-snapshots/")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://repo.opencollab.dev/main/")
        maven("https://repo.opencollab.dev/maven-snapshots/")
        maven("https://repo.opencollab.dev/maven-releases/")
        maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
        maven("https://repo.extendedclip.com/releases/")
        maven("https://repo.dmulloy2.net/repository/public/")
        maven("https://repo.luckperms.net/releases/")
        maven("https://repo.codemc.io/repository/maven-public/")
        maven("https://repo.codemc.io/repository/maven-releases/")
        maven("https://repo.codemc.io/repository/maven-snapshots/")
        maven("https://maven.enginehub.org/repo/")
        maven("https://jitpack.io")
    }
}

rootProject.name = "MLang"
