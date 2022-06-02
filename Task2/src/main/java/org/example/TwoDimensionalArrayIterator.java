package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDimensionalArrayIterator<T> implements Iterator<T> {

    private final T[][] array;
    private int row;
    private int column;
    private final int length;

    public TwoDimensionalArrayIterator(T[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null!");
        }

        this.array = array;
        this.length = array.length;
    }

    @Override
    public boolean hasNext() {
        if (length == 0) {
            return false;
        }

        while ((row < length) && (column == array[row].length)) {
            column = 0;
            row++;
        }

        return (row < length) && (column < array[row].length);
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Array has no more elements");
        }

        if ((row < length) && (column < array[row].length)) {
            return array[row][column++];
        }

        if (++row < length) {
            return array[row][0];
        }

        throw new NoSuchElementException();
    }
}