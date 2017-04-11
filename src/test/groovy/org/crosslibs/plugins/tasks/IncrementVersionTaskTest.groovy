package org.crosslibs.plugins.tasks

import org.crosslibs.plugins.Constants
import org.crosslibs.semver.SemanticVersion
import org.gradle.api.DefaultTask
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.crosslibs.plugins.utils.TestUtils.runAndAssertEqual

/**
 * @author cpdews (cpdevws@gmail.com)
 */
public class IncrementVersionTaskTest {

    def project = ProjectBuilder.builder().build()
    DefaultTask task
    def file

    @Rule
    public TemporaryFolder folder = new TemporaryFolder()

    @Before
    void setup(){
        project.pluginManager.apply Constants.PLUGIN_NAME
        task = project.task('incrementCurrentVersion', type: IncrementVersionTask)
        file = folder.newFile('testVersion.properties')
        file << '''version=1.2.3-SNAPSHOT'''
    }

    @Test
    void should_validate_that_the_increment_version_task_is_added(){
        assert task instanceof IncrementVersionTask
    }

    @Test
    void should_return_default_version_when_version_properties_file_is_not_available(){
        runAndAssertEqual "Next Version: 0.0.0", { task.execute() }
    }

    @Test
    void should_return_version_from_properties_when_version_properties_file_is_available(){
        assert (task as IncrementVersionTask).increment(file.path) == new SemanticVersion('1.2.4-SNAPSHOT')
    }

}