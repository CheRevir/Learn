package com.cere.plugin.logic

import com.cere.plugin.task.LogicTask
import org.gradle.api.Plugin
import org.gradle.api.Project

 class LogicPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println(">>>>>>>>>> Build Logic <<<<<<<<<<")
        target.tasks.register("aaaafdgsdfgsdgf", LogicTask::class.java)
        with(target){

        }
    }
}