package org.crosslibs.plugins

import org.crosslibs.plugins.tasks.CurrentVersionTask
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author cpdews (cpdevws@gmail.com)
 */
public class VersionPluginTest {

    def project = ProjectBuilder.builder().build()

    @Before
    void setup(){
        project.pluginManager.apply Constants.PLUGIN_NAME
    }

    @Test
    void should_add_current_version_task_to_project(){
        assert project.tasks.currentVersion instanceof CurrentVersionTask
    }

}