package com.cere.plugin.logic

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
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
            }
        }
    }
}