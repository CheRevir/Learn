package com.cere.plugin.logic

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {

                configureKotlinAndroid(this)

                @Suppress("UnstableApiUsage")
                buildFeatures {
                    viewBinding = true
                    dataBinding = true
                }

                dependencies {
                    "implementation"(libs.findLibrary("androidx.core.ktx").get())
                    add("implementation", libs.findLibrary("androidx.appcompat").get())
                    add("implementation", libs.findLibrary("androidx.constraintlayout").get())
                    add("implementation", libs.findLibrary("androidx.lifecycle.livedata").get())
                    add("implementation", libs.findLibrary("androidx.lifecycle.viewmodel").get())
                    add("implementation", libs.findLibrary("androidx.navigation.fragment").get())
                    add("implementation", libs.findLibrary("androidx.navigation.ui").get())
                    add("implementation", libs.findLibrary("material").get())

                    "testImplementation"(libs.findLibrary("junit").get())
                    "androidTestImplementation"(libs.findLibrary("androidx.test.ext.junit").get())
                    "androidTestImplementation"(
                        libs.findLibrary("androidx.test.espresso.core").get()
                    )
                }
            }
        }
    }
}