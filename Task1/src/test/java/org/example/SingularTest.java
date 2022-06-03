package org.example;

import org.junit.Test;

import java.util.*;

import static org.example.Singular.removeDuplicates;
import static org.junit.Assert.assertEquals;

public class SingularTest {

    static final List<String> INPUT_STRING_LIST = new ArrayList<>();
    static final Set<String> RESULT_STRING_SET = new HashSet<>();
    static final List<Object> INPUT_OBJECT_LIST = new ArrayList<>();
    static final Set<Object> RESULT_OBJECT_SET = new HashSet<>();

    static {
        INPUT_STRING_LIST.add("root");
        INPUT_STRING_LIST.add("root");
        INPUT_STRING_LIST.add("http");
        INPUT_STRING_LIST.add("ftp");
        INPUT_STRING_LIST.add("https");
        INPUT_STRING_LIST.add("ftp");
        INPUT_STRING_LIST.add("root");

        RESULT_STRING_SET.add("root");
        RESULT_STRING_SET.add("http");
        RESULT_STRING_SET.add("ftp");
        RESULT_STRING_SET.add("https");

        INPUT_OBJECT_LIST.add(new Date(1000));
        INPUT_OBJECT_LIST.add(new Date(2000));
        INPUT_OBJECT_LIST.add(new Date(2000));
        INPUT_OBJECT_LIST.add(12);
        INPUT_OBJECT_LIST.add(2.9021);
        INPUT_OBJECT_LIST.add(2.9021);
        INPUT_OBJECT_LIST.add("Greece");

        RESULT_OBJECT_SET.add(new Date(1000));
        RESULT_OBJECT_SET.add(new Date(2000));
        RESULT_OBJECT_SET.add(12);
        RESULT_OBJECT_SET.add(2.9021);
        RESULT_OBJECT_SET.add("Greece");
    }

    @Test
    public void makeNoDuplicatesSavingOrder() {
        assertEquals("String collection mutation failed", removeDuplicates(INPUT_STRING_LIST), RESULT_STRING_SET);
        assertEquals("Object collection mutation failed", removeDuplicates(INPUT_OBJECT_LIST), RESULT_OBJECT_SET);
    }
}