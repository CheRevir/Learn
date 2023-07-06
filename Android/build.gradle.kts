/*
buildscript {
     val hiltVersion = "2.46.1"
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}
*/


/*plugins {
    id("com.android.application") version "7.4.2" apply false
    id("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.20" apply false
}*/



plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.hilt) apply false
}
