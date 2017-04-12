package org.crosslibs.plugins.tasks

import org.crosslibs.semver.SemanticVersion
import org.crosslibs.plugins.Constants
import org.crosslibs.plugins.extensions.VersionPluginExtension
import org.crosslibs.plugins.utils.Version
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Current Version Task
 *
 * Shows the current version information
 *
 * @author cpdews (cpdevws@gmail.com)
 */
class CurrentVersionTask extends DefaultTask {

    /**
     * Class Constructor
     */
    CurrentVersionTask(){
        description = Constants.PLUGIN_TASK_CURRENT_VERSION_DESC
        group = Constants.PLUGIN_TASKS_GROUP
    }

    /**
     * Create currentVersion task
     */
    @TaskAction
    void currentVersion(){
        println "Current Version: ${Version.current(project)}"
    }

}
