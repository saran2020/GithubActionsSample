dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven( uri("$rootDir/mvn-libraries/"))
    }
}

rootProject.name = "Local maven publish sample"
include(":app")
include(":samplelibrary")
