package org.crosslibs.plugins.extensions

import org.crosslibs.plugins.Constants
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author cpdews (cpdevws@gmail.com)
 */
public class VersionPluginExtensionTest {

    def ext

    @Before
    void setup(){
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply Constants.PLUGIN_NAME
        ext = project.extensions.getByType(VersionPluginExtension)
    }

    @Test
    void should_return_string_format(){
        assert (new VersionPluginExtension()).toString() == "file: ${VersionPluginExtension.DEFAULT_VERSION_PROPS_FILE}"
    }


}