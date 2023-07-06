package com.cere.build.logic

import com.cere.build.task.LogicTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class LogicPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println(">>>>>>>>>> Build Logic <<<<<<<<<<")
        target.tasks.register("app", LogicTask::class.java)
        with(target){

        }
    }
}