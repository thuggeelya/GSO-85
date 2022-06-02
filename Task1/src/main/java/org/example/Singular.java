package org.example;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Singular {

    public static Collection<?> getNoDuplicatesCollection(Collection<?> collection) {
        return (collection == null) || (collection.isEmpty())
                ? collection
                : new LinkedHashSet<>(collection);
//                : new ArrayList<>(new LinkedHashSet<>(collection));
    }
}