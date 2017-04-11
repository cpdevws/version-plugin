package org.crosslibs.plugins.extensions

/**
 * Version plugins extension
 *
 * The extension specifies the version properties file location
 *
 * @author cpdews (cpdevws@gmail.com)
 */
class VersionPluginExtension {

    static final String DEFAULT_VERSION_PROPS_FILE = 'version.properties'

    /**
     * Location (Path) of the version properties file
     */
    String file

    /**
     * Class Constructor
     * @param file Version properties file (optional, default = version.properties)
     */
    VersionPluginExtension(String file = DEFAULT_VERSION_PROPS_FILE){
        this.file = file
    }

    /**
     * String representation of the version plugin extension
     * @return VersionPluginExtension in string format
     */
    @Override
    String toString(){
        return "file: ${file}"
    }

}
