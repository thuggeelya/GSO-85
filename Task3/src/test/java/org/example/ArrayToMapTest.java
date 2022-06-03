package org.example;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.example.ElementCounter.arrayToElementCountMap;
import static org.junit.Assert.assertEquals;

public class ArrayToMapTest {

    @Test
    public void simpleElementCount() {
        Object o1 = new Object();
        Object o2 = new Object();
        Object[] oArray = {o1, o1, 12, o2, 12, o1, "city"};
        Map<Object, Integer> mapExpected = new HashMap<>();
        mapExpected.put(o1, 3);
        mapExpected.put(12, 2);
        mapExpected.put(o2, 1);
        mapExpected.put("city", 1);
        Map<?, Integer> mapActual = arrayToElementCountMap(oArray);
        assertEquals("Maps differ", mapExpected, mapActual);
    }

    @Test
    public void emptyOrNullArray() {
        Object[] oArray = {};
        Map<?, Integer> mapExpected = new HashMap<>();
        Map<?, Integer> mapActual1 = arrayToElementCountMap(oArray);
        Map<?, Integer> mapActual2 = arrayToElementCountMap(null);
        assertEquals("Maps differ (empty)", mapExpected, mapActual1);
        assertEquals("Maps differ (null)", mapExpected, mapActual2);
    }
}