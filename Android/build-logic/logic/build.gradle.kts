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
    implementation(gradleApi())
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("logicPlugin") {
            id = "com.cere.plugin.logic"
            implementationClass = "com.cere.plugin.logic.LogicPlugin"
        }
        register("applicationPlugin") {
            id = "com.cere.application"
            implementationClass = "com.cere.plugin.logic.AndroidApplicationPlugin"
        }
        register("hiltPlugin") {
            id = "com.cere.hilt"
            implementationClass = "com.cere.plugin.logic.AndroidHiltPlugin"
        }
    }
}