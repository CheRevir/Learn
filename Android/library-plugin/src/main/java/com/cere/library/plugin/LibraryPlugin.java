package com.cere.library.plugin;

import com.cere.library.plugin.task.TestTask;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class LibraryPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        System.out.print(">>>>>>>>>> LibraryPlugin <<<<<<<<<<<<");

        project.getTasks().register("safasf", TestTask.class);
    }
}