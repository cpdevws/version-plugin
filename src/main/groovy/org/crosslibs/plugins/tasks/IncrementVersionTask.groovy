package org.crosslibs.plugins.tasks

import org.crosslibs.semver.SemanticVersion
import org.crosslibs.plugins.Constants
import org.crosslibs.plugins.extensions.VersionPluginExtension
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
        def version = project.extensions.getByName(Constants.PLUGIN_EXT) as VersionPluginExtension
        println "Next Version: ${increment version.file }"
    }

    /**
     * Increments the version to the next as per semantic version rules
     * If version properties file is present, then the incremented version is persisted
     * Otherwise, the default version is returned
     * @param path File containing the version properties
     * @return the next version
     */
    def increment(path){
        Properties properties = new Properties()
        SemanticVersion version = new SemanticVersion()
        try {
            File propertiesFile = new File(path)
            properties.load(propertiesFile.newDataInputStream())
            version = new SemanticVersion(properties.getProperty(Constants.PLUGIN_PROPERTY_NAME_VERSION))
            version++
            properties.setProperty(Constants.PLUGIN_PROPERTY_NAME_VERSION, version.toString())
            properties.store(propertiesFile.newWriter(), null)
        }
        catch(Exception e){
            // Ignore exception
        }

        return version
    }

}
