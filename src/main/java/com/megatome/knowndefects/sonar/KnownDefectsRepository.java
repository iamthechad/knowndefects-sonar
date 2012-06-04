package com.megatome.knowndefects.sonar;

import org.apache.commons.io.IOUtils;
import org.sonar.api.resources.Java;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleRepository;
import org.sonar.api.rules.XMLRuleParser;

import java.io.InputStream;
import java.util.List;

public class KnownDefectsRepository extends RuleRepository {

    private XMLRuleParser xmlRuleParser;

    public KnownDefectsRepository(final XMLRuleParser xmlRuleParser) {
        super("checkstyle", Java.KEY);
        setName("Checkstyle");
        this.xmlRuleParser = xmlRuleParser;
    }

    @Override
    public List<Rule> createRules() {
        final InputStream inputStream = getClass().getResourceAsStream("/com/megatome/knowndefects/sonar/knowndefects-extension.xml");
        try {
            return xmlRuleParser.parse(inputStream);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }
}
