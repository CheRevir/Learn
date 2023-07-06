package com.cere.plugin.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class LogicTask : DefaultTask() {
    init {
        group = "logic"
    }

    @TaskAction
    fun doTaskAction(){
        println("asdfasdkfajlskdfjalsdkfasdf")
    }
}