package org.example;

import org.junit.Test;

import java.util.*;

import static org.example.MapReverser.reverseMap;
import static org.junit.Assert.assertEquals;

public class MapReverserTest {

    @Test
    public void reverseSimpleMap() {
        Map<String, Long> inputMap = new HashMap<>();
        inputMap.put("First Max", Long.MAX_VALUE);
        inputMap.put("Second Max", Long.MAX_VALUE);
        inputMap.put("Third Max", Long.MAX_VALUE);
        inputMap.put("First Min", Long.MIN_VALUE);
        inputMap.put("Second Min", Long.MIN_VALUE);
        inputMap.put("Third Min", Long.MIN_VALUE);
        List<String> maxValues = new ArrayList<>();
        maxValues.add("First Max");
        maxValues.add("Second Max");
        maxValues.add("Third Max");
        List<String> minValues = new ArrayList<>();
        minValues.add("First Min");
        minValues.add("Second Min");
        minValues.add("Third Min");
        Map<Long, Collection<String>> expectedMap = new HashMap<>();
        expectedMap.put(Long.MAX_VALUE, maxValues);
        expectedMap.put(Long.MIN_VALUE, minValues);
        assertEquals("Maps differ", expectedMap, reverseMap(inputMap));
    }

    @Test
    public void reverseEmptyOrNullMap() {
        Map<String, Long> inputMap = new HashMap<>();
        Map<Long, Collection<String>> expectedMap = new HashMap<>();
        assertEquals("Maps differ (empty)", expectedMap, reverseMap(inputMap));
        assertEquals("Maps differ (null)", expectedMap, reverseMap(null));
    }
}