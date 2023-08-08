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
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

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
