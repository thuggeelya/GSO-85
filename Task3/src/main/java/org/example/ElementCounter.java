package org.example;

import java.util.HashMap;
import java.util.Map;

public class ElementCounter {

    public static <K> Map<K, Integer> arrayToElementCountMap(K[] array) {
        Map<K, Integer> map = new HashMap<>();

        if ((array == null) || (array.length == 0)) {
            return map;
        }

        for (K element : array) {
//            map.merge(element, 1, Integer::sum);
            Integer currentValue = map.putIfAbsent(element, 1);

            if (currentValue != null) {
                map.put(element, ++currentValue);
            }
        }

        return map;
    }
}