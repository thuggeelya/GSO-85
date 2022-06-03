package org.example;

import java.util.HashMap;
import java.util.Map;

public class ElementCounter {

    public static <K> Map<K, Integer> arrayToElementCountMap(K[] array) {
        Map<K, Integer> resultMap = new HashMap<>();
        Map<K, MutableInt> map = new HashMap<>();

        if ((array == null) || (array.length == 0)) {
            return resultMap;
        }

        for (K element : array) {
            MutableInt currentValue = map.get(element);

            if (currentValue == null) {
                MutableInt defaultInt = new MutableInt();
                currentValue = map.putIfAbsent(element, defaultInt);
                currentValue = (currentValue == null) ? defaultInt : currentValue;
            }

            currentValue.increment();
        }

        for (Map.Entry<K, MutableInt> mapEntry : map.entrySet()) {
            resultMap.put(mapEntry.getKey(), mapEntry.getValue().get());
        }

        return resultMap;
    }
}