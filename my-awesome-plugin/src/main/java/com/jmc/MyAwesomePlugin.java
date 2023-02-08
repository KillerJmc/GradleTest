package com.jmc;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * 自定义插件
 * @author Jmc
 */
@SuppressWarnings("unused")
public class MyAwesomePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.task("my-awesome-task", task -> {
            System.out.println("正在配置：my-awesome-task");

            task.doLast(t -> System.out.println("正在运行：my-awesome-task"));
        });
    }
}
