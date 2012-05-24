package com.megatome.knowndefects.sonar;

import com.google.common.collect.Lists;
import org.sonar.api.SonarPlugin;

import java.util.List;

public class KnownDefectsPlugin extends SonarPlugin {
    @Override
    public List getExtensions() {
        return Lists.newArrayList(KnownDefectsSensor.class);
    }
}
