package org.example;

import org.junit.Test;

import java.util.*;

import static org.example.Singular.removeDuplicates;
import static org.junit.Assert.assertEquals;

public class SingularTest {

    static final List<String> INPUT_STRING_LIST = new ArrayList<String>() {{
        add("root");
        add("root");
        add("http");
        add("ftp");
        add("https");
        add("ftp");
        add("root");
    }};

    static final Set<String> RESULT_STRING_SET = new HashSet<String>() {{
        add("root");
        add("http");
        add("ftp");
        add("https");
    }};

    static final List<Object> INPUT_OBJECT_LIST = new ArrayList<Object>() {{
        add(new Date(1000));
        add(new Date(2000));
        add(new Date(2000));
        add(12);
        add(2.9021);
        add(2.9021);
        add("Greece");
    }};

    static final Set<Object> RESULT_OBJECT_SET = new HashSet<Object>() {{
        add(new Date(1000));
        add(new Date(2000));
        add(12);
        add(2.9021);
        add("Greece");
    }};

    @Test
    public void makeNoDuplicatesSavingOrder() {
        assertEquals("String collection mutation failed", removeDuplicates(INPUT_STRING_LIST), RESULT_STRING_SET);
        assertEquals("Object collection mutation failed", removeDuplicates(INPUT_OBJECT_LIST), RESULT_OBJECT_SET);
    }
}