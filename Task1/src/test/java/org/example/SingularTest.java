package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.Singular.getNoDuplicatesCollection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SingularTest {

    static final List<String> INPUT_STRING_LIST = new ArrayList<String>(){{
        add("root");
        add("root");
        add("http");
        add("ftp");
        add("https");
        add("ftp");
        add("root");
    }};

    static final List<String> RESULT_STRING_LIST_ORDER_SAVED = new ArrayList<String>(){{
        add("root");
        add("http");
        add("ftp");
        add("https");
    }};

    static final List<String> RESULT_STRING_LIST_ORDER_CHANGED = new ArrayList<String>(){{
        add("ftp");
        add("https");
        add("root");
        add("http");
    }};

    static final List<Object> INPUT_OBJECT_LIST = new ArrayList<Object>(){{
        add(new Date(1000));
        add(new Date(2000));
        add(new Date(2000));
        add(12);
        add(2.9021);
        add(2.9021);
        add("Greece");
    }};

    static final List<Object> RESULT_OBJECT_LIST_ORDER_SAVED = new ArrayList<Object>(){{
        add(new Date(1000));
        add(new Date(2000));
        add(12);
        add(2.9021);
        add("Greece");
    }};

    @Test
    public void makeNoDuplicatesSavingOrder() {
        assertEquals("String collection mutation failed", getNoDuplicatesCollection(INPUT_STRING_LIST), RESULT_STRING_LIST_ORDER_SAVED);
        assertEquals("Object collection mutation failed", getNoDuplicatesCollection(INPUT_OBJECT_LIST), RESULT_OBJECT_LIST_ORDER_SAVED);
        assertNotEquals(getNoDuplicatesCollection(INPUT_STRING_LIST), RESULT_STRING_LIST_ORDER_CHANGED);
    }
}