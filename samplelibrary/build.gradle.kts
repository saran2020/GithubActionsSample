plugins {
    id("kotlin")
    id("maven-publish")
}

val artifactGroupId = "dev.sankaran.saran"
val artifactName = "samplelibrary"
val artifactVersion = "0.0.1"

project.afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = artifactGroupId
                artifactId = artifactName
                version = artifactVersion

                from(components["java"])
            }
        }

        repositories {
            maven {
                name = "Sample"
                url = uri(System.getenv("PUBLISH_PATH"))
            }
        }
    }
}