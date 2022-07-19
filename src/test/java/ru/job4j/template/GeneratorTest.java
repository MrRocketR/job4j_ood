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
        Assert.assertTrue(testMap.isEmpty());
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenEmptyTemplate() {
        Assert.assertTrue(template.isEmpty());
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNullValue() {
        template = "I am a ${name}, Who are ${subject}? ";
        testMap.put("Petr", null);
        testGen.produce(template, testMap);
        Assert.assertNull(testMap.get("Petr"));
    }
}