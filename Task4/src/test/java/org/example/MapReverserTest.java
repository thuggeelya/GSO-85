package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.example.MapReverser.reverseMap;
import static org.junit.Assert.assertEquals;

public class MapReverserTest {

    @Test
    public void reverseSimpleMap() {
        Map<String, Long> inputMap = new HashMap<String, Long>() {{
            put("First Max", Long.MAX_VALUE);
            put("Second Max", Long.MAX_VALUE);
            put("Third Max", Long.MAX_VALUE);
            put("First Min", Long.MIN_VALUE);
            put("Second Min", Long.MIN_VALUE);
            put("Third Min", Long.MIN_VALUE);
        }};
        Map<Long, Collection<String>> expectedMap = new HashMap<Long, Collection<String>>() {{
           put(Long.MAX_VALUE, new ArrayList<String>() {{
               add("First Max");
               add("Second Max");
               add("Third Max");
           }});
            put(Long.MIN_VALUE, new ArrayList<String>() {{
                add("First Min");
                add("Second Min");
                add("Third Min");
            }});
        }};
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