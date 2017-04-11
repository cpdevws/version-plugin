package org.crosslibs.plugins.tasks

import org.crosslibs.semver.SemanticVersion
import org.crosslibs.plugins.Constants
import org.crosslibs.plugins.extensions.VersionPluginExtension
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
        def version = project.extensions.getByName(Constants.PLUGIN_EXT) as VersionPluginExtension
        println "Current Version: ${getVersion version.file}"
    }

    /**
     * Returns the current version of the project
     * @param path Path of the version properties file
     * @return semantic version of the project
     */
    def getVersion(path){
        Properties properties = new Properties()
        SemanticVersion semanticVersion = new SemanticVersion()
        try {
            File propertiesFile = new File(path)
            properties.load(propertiesFile.newDataInputStream())
            semanticVersion = new SemanticVersion(properties.getProperty(Constants.PLUGIN_PROPERTY_NAME_VERSION))
        }
        catch(Exception e){
            // Ignore exception
        }
        return semanticVersion
    }

}
