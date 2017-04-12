package org.crosslibs.plugins

import org.crosslibs.plugins.extensions.VersionPluginExtension
import org.crosslibs.plugins.tasks.CurrentVersionTask
import org.crosslibs.plugins.tasks.IncrementVersionTask
import org.crosslibs.plugins.utils.Version
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Version Plugin
 *
 * Gradle Version Plugin allows for the project version to be displayed or incremented by reading
 * the specified version properties file (VersionPluginExtension)
 *
 * @author cpdews (cpdevws@gmail.com)
 */
class VersionPlugin implements Plugin<Project> {

    /**
     * Adds extension and plugins tasks to the project
     * @param project Project object
     */
    @Override
    void apply(Project project) {
        project.extensions.create Constants.PLUGIN_EXT, VersionPluginExtension
        project.tasks.create Constants.PLUGIN_TASK_CURRENT_VERSION, CurrentVersionTask
        project.tasks.create Constants.PLUGIN_TASK_INCREMENT_VERSION, IncrementVersionTask
        project.setVersion(Version.current(project))
    }
}
