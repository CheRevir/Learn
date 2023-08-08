package com.cere.plugin.logic

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.cere.plugin.task.LogicTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure

class LogicPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println(">>>>>>>>>> Build Logic <<<<<<<<<<")
        with(target){
            with(pluginManager){
                apply("com.android.application")
            }
            extensions.configure<BaseAppModuleExtension>{
                applicationVariants.all {v->
                    v.outputs.all {

                    }
                    v.outputs.all {
                        println(this.outputFile.path)
                    }
                    true
                }
            }
        }

        target.tasks.register("logic", LogicTask::class.java){
            doFirst {
                println("asdfasdfadfsa")
            }
            getOwner().set("sadfasdfadfasdfasdfasdfasdfasdlkf6666666666666666666666666")
        }
    }
}