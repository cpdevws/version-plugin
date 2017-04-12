package org.crosslibs.plugins.tasks

import org.crosslibs.semver.SemanticVersion
import org.crosslibs.plugins.Constants
import org.crosslibs.plugins.extensions.VersionPluginExtension
import org.crosslibs.plugins.utils.Version
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Increment Version Task
 *
 * Increments the current version and updates the version properties file with the incremented version
 *
 * @author cpdews (cpdevws@gmail.com)
 */
class IncrementVersionTask extends DefaultTask {

    /**
     * Class constructor
     */
    IncrementVersionTask(){
        description = Constants.PLUGIN_TASK_INCREMENT_VERSION_DESC
        group = Constants.PLUGIN_TASKS_GROUP
    }

    /**
     * Increment the version to the next as per semantic version rules
     * @return the next version (also persisted into the plugins properties file)
     */
    @TaskAction
    def incrementVersion(){
        println "Next Version: ${Version.increment(project)}"
    }

}
