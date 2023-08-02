package com.cere.plugin.logic

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                println(this.defaultConfig.applicationId)

                compileSdk = libs.findVersion("compileSdk").get().requiredVersion.toInt()

                println(compileSdk)

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }

                tasks.withType<KotlinCompile>().configureEach {
                    kotlinOptions {
                        jvmTarget = JavaVersion.VERSION_11.toString()
                    }
                }

                buildFeatures {
                    viewBinding = true
                    dataBinding = true
                }

                dependencies {
                    "implementation"(libs.findLibrary("androidx.core.ktx").get())
                    add("implementation", libs.findLibrary("androidx.appcompat").get())
                    add("implementation", libs.findLibrary("androidx.material").get())
                    add("implementation", libs.findLibrary("androidx.constraintlayout").get())
                    add("implementation", libs.findLibrary("androidx.lifecycle.livedata").get())
                    add("implementation", libs.findLibrary("androidx.lifecycle.viewmodel").get())
                    add("implementation", libs.findLibrary("androidx.navigation.fragment").get())
                    add("implementation", libs.findLibrary("androidx.navigation.ui").get())

                    "testImplementation"(libs.findLibrary("junit").get())
                    "androidTestImplementation"(libs.findLibrary("androidx.test.ext").get())
                    "androidTestImplementation"(libs.findLibrary("androidx.espresso.core").get())
                }
            }
        }
    }
}