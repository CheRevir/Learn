package com.cere.library.plugin.task;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class TestTask extends DefaultTask {
    public TestTask() {
        setGroup("TesasdfasdftTask");
    }

    @TaskAction
    public void doTaskAction() {
        System.out.print("--------------TestTask");
    }
}
