plugins {
    id("com.cere.application")
    id("com.cere.hilt")
    id("com.cere.plugin.logic")
}

android {
    namespace = "com.cere.learn"
    //compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.cere.learn"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    @Suppress("UnstableApiUsage")
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":flutter-core"))
}


