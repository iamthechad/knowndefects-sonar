package com.megatome.knowndefects.sonar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.resources.*;

import java.util.List;

public class KnownDefectsSensor implements Sensor {
    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean shouldExecuteOnProject(Project project) {
        return project.getLanguage().equals(Java.INSTANCE);
    }

    @Override
    public void analyse(Project project, SensorContext sensorContext) {
        ProjectFileSystem projectFileSystem = project.getFileSystem();
        final List<InputFile> testSources = projectFileSystem.testFiles(Java.SUFFIXES);
        for (final InputFile inputFile : testSources) {
            logger.info("Looking at file: " + inputFile.toString());
            JavaFile javaFile = JavaFile.fromIOFile(inputFile.getFile(), projectFileSystem.getTestDirs(), true);
            if (null != javaFile) {

            }
        }
    }
}
