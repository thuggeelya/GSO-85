package org.example;

import java.util.Collection;
import java.util.HashSet;

public class Singular {

    public static Collection<?> removeDuplicates(Collection<?> collection) {
        return (collection == null) || (collection.isEmpty())
                ? collection
                : new HashSet<>(collection);
//                : new LinkedHashSet<>(collection);
//                : new ArrayList<>(new LinkedHashSet<>(collection));
    }
}