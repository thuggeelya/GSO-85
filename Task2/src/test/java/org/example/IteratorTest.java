package org.example;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class IteratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void nullArray() {
        new TwoDimensionalArrayIterator<>(null);
    }

    @Test
    public void firstEmptySecondPresent() {
        Integer[][] array = {{}, {0}};
        TwoDimensionalArrayIterator<Integer> iterator = new TwoDimensionalArrayIterator<>(array);
        assertNotNull(iterator.next());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void oneElement() {
        String[][] array = {{"moon"}};
        TwoDimensionalArrayIterator<String> iterator = new TwoDimensionalArrayIterator<>(array);
        assertNotNull(iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void differentRowSize() {
        Integer[][] array = {{0}, {1, 2}, {3}};
        TwoDimensionalArrayIterator<Integer> iterator = new TwoDimensionalArrayIterator<>(array);
        assertEquals(iterator.next(), Integer.valueOf(0));
        assertEquals(iterator.next(), Integer.valueOf(1));
        assertEquals(iterator.next(), Integer.valueOf(2));
        assertEquals(iterator.next(), Integer.valueOf(3));
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void multipleEmptyRows() {
        Integer[][] array = {{0}, {}, {}, {}, {9}};
        TwoDimensionalArrayIterator<Integer> iterator = new TwoDimensionalArrayIterator<>(array);
        assertEquals(iterator.next(), Integer.valueOf(0));
        assertEquals(iterator.next(), Integer.valueOf(9));
        assertFalse(iterator.hasNext());
    }

    @Test
    public void emptyArray() {
        Integer[][] array = {};
        TwoDimensionalArrayIterator<Integer> iterator = new TwoDimensionalArrayIterator<>(array);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void multipleHasNext() {
        Integer[][] array = {{}, {}};
        TwoDimensionalArrayIterator<Integer> iterator = new TwoDimensionalArrayIterator<>(array);
        assertEquals(iterator.hasNext(), iterator.hasNext());
    }
}