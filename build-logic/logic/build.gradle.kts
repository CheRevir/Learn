import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("logicPlugin") {
            id = "com.cere.build.logic"
            implementationClass = "com.cere.build.logic.LogicPlugin"
        }
        register("applicationPlugin") {
            id = "com.cere.application"
            implementationClass = "com.cere.build.logic.AndroidApplicationPlugin"
        }
        register("hiltPlugin") {
            id = "com.cere.hilt"
            implementationClass = "com.cere.build.logic.AndroidHiltPlugin"
        }
    }
}