/*
Implement a CircularArray class that supports an array-like data structure which can be efficiently rotated. The class should 
use
a generic type, and should support iteration via standard for(Obj o:circularArray) notation.
*/

import java.lang.*;
import java.lang.IndexOutOfBoundsException;
import java.lang.Iterable;
import java.lang.Object;
import java.lang.Override;
import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
    private  T[] items;
    private int head = 0;

    public CircularArray(int size) {
        items = (T[]) new Object[size];     //worth attention
    }

    public int convert(int index) {
        if(index<0)                         //worth attention
            index+=items.length;
        return (head+index)%items.length;
    }

    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public T get(int i) {
        if(i<0||i>=items.length)
            throw new IndexOutOfBoundsException("...");
        return items[convert(i)];
    }

    public void set(int i,T item) {
        items[convert(i)] = item;
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator<T>(this);
    }

    //iterator class
    public class CircularArrayIterator<TI> implements Iterator<TI> {
        private int _current = -1;
        private TI[] _items;

        public CircularArrayIterator(CircularArray<TI> array) {
            _items = array.items;
        }

        @Override
        public boolean hasNext() {
            return _current<_items.length-1;
        }

        @Override
        public TI next() {
            _current++;
            TI item = (TI) _items[convert(_current)];
            return item;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("...");
        }
    }
}
