plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}

val artifactGroupId = "dev.sankaran.saran"
val artifactName = "samplelibray"
val artifactVersion = "0.0.1"

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 21
        targetSdk = 30
        // Setting this version can be ignored, as long as we are not doing version
        // check within the library.
        version = 1

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
}

project.afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = artifactGroupId
                artifactId = artifactName
                version = artifactVersion

                from(components["release"])
            }
        }

        repositories {
            maven {
                name = "Sample"
                url = uri("$rootDir/mvn-libraries")
            }
        }
    }
}