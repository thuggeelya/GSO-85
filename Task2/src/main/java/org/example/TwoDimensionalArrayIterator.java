package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDimensionalArrayIterator<T> implements Iterator<T> {

    private final T[][] array;
    private int row;
    private int column;

    public TwoDimensionalArrayIterator(T[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null!");
        }

        this.array = array;
    }

    @Override
    public boolean hasNext() {
        int arrLength = array.length;

        if (arrLength == 0) {
            return false;
        }

        while ((row < arrLength) && (column == array[row].length)) {
            column = 0;
            row++;
        }

        return (row < arrLength) && (column < array[row].length);
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Array has no more elements");
        }

        int arrLength = array.length;

        if ((row < arrLength) && (column < array[row].length)) {
            return array[row][column++];
        }

        if (++row < arrLength) {
            return array[row][0];
        }

        throw new NoSuchElementException();
    }
}