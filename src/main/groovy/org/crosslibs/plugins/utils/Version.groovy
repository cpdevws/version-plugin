package org.crosslibs.plugins.utils

import org.gradle.api.Project
import org.crosslibs.semver.SemanticVersion
import org.crosslibs.plugins.Constants
import org.crosslibs.plugins.extensions.VersionPluginExtension

/**
 * Version Utility
 *
 * Reads or updates the version properties file
 *
 * @author cpdews (cpdevws@gmail.com)
 */
class Version {

    /**
     * Returns the current version of the project
     * @param project Gradle project object
     * @return semantic version of the project
     */
    static SemanticVersion current(Project project){
        def versionExt = project.extensions.getByName(Constants.PLUGIN_EXT) as VersionPluginExtension
        Properties properties = new Properties()
        SemanticVersion semanticVersion = new SemanticVersion()
        try {
            File propertiesFile = new File(versionExt.file)
            properties.load(propertiesFile.newDataInputStream())
            semanticVersion = new SemanticVersion(properties.getProperty(Constants.PLUGIN_PROPERTY_NAME_VERSION))
        }
        catch(Exception e){
            // Ignore exception
        }
        project.setVersion(semanticVersion)
        return semanticVersion
    }

    /**
     * Increments the version to the next as per semantic version rules
     * If version properties file is present, then the incremented version is persisted
     * Otherwise, the default version is returned
     * @param project Gradle project object
     * @return the next version
     */
    static SemanticVersion increment(Project project){
        def versionExt = project.extensions.getByName(Constants.PLUGIN_EXT) as VersionPluginExtension
        Properties properties = new Properties()
        SemanticVersion version = new SemanticVersion()
        try {
            File propertiesFile = new File(versionExt.file)
            properties.load(propertiesFile.newDataInputStream())
            version = new SemanticVersion(properties.getProperty(Constants.PLUGIN_PROPERTY_NAME_VERSION))
            version++
            properties.setProperty(Constants.PLUGIN_PROPERTY_NAME_VERSION, version.toString())
            properties.store(propertiesFile.newWriter(), null)
        }
        catch(Exception e){
            // Ignore exception
        }
        project.setVersion(version)
        return version
    }
}