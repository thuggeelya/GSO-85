package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapReverser {

    public static <K, V> Map<V, Collection<K>> reverseMap(Map<K, V> map) {
        Map<V, Collection<K>> reversedMap = new HashMap<>();

        if ((map == null) || map.isEmpty()) {
            return reversedMap;
        }

        for (Map.Entry<K, V> pair : map.entrySet()) {
            V value = pair.getValue();
            Collection<K> keys = reversedMap.get(value);

            if (keys == null) {
                Collection<K> defaultKeys = new ArrayList<>();
                keys = reversedMap.putIfAbsent(value, defaultKeys);

                if (keys == null) {
                    keys = defaultKeys;
                }
            }

            keys.add(pair.getKey());
        }

        return reversedMap;
    }
}