package com.cere.plugin.task

import org.gradle.api.Action
import org.gradle.api.DefaultTask
import org.gradle.api.Task
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

abstract class LogicTask : DefaultTask() {
    @Input
    abstract fun getOwner(): Property<String>

    init {
        group = "logic"
    }

    @TaskAction
    fun doTaskAction() {
        println(getOwner().get())
        println("asdf55555555555555555555555555555555555555555555555555555")
    }

    override fun doFirst(action: Action<in Task>): Task {
        println("LogicTask Start")
        return super.doFirst(action)
    }

    override fun doLast(action: Action<in Task>): Task {
        println("LogicTask End")
        return this
    }
}