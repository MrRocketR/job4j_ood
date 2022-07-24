package ru.job4j.template;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {
    private Map<String, String> testMap = new HashMap<>();
    private Generator testGen = new TemplateGenerator();
    private String template;

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyMap() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        template =  "Test ${name} and ${subject}";
        templateGenerator.produce(template, testMap);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyTemplate() {
        TemplateGenerator templateGenerator = new TemplateGenerator();
        testMap.put("robot", "bot");
        templateGenerator.produce(template, testMap);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNullValue() {
        template = "I am a ${name}, Who are ${subject}? ";
        testMap.put("Petr", null);
        TemplateGenerator templateGenerator = new TemplateGenerator();
        templateGenerator.produce(template, testMap);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenProduceWork() {
        template = "I am a ${name}, Who are ${subject}? ";
        testMap.put("Petr", "Same Petr");
        TemplateGenerator templateGenerator = new TemplateGenerator();
        templateGenerator.produce(template, testMap);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenWrongKey() {
        template = "I am a ${name}, Who are ${subject}? ";
        testMap.put("Petr", "Same Petr");
        TemplateGenerator templateGenerator = new TemplateGenerator();
        templateGenerator.produce(template, testMap);
        Assert.assertNotEquals(testMap.get("Petr"), "Same Oleg");
    }
}
