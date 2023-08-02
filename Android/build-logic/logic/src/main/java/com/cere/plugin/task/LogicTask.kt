package com.cere.plugin.task

import org.gradle.api.Action
import org.gradle.api.DefaultTask
import org.gradle.api.Task
import org.gradle.api.tasks.TaskAction

abstract class LogicTask : DefaultTask() {
    init {
        group = "logic"
    }

    @TaskAction
    fun doTaskAction() {
        println("ggggggggggg")
    }

    override fun doFirst(action: Action<in Task>): Task {
        println("LogicTask Start")
        return this
    }

    override fun doLast(action: Action<in Task>): Task {
        println("LogicTask End")
        return this
    }
}