package com.shashank.ps.designPatterns.iterator;

import java.util.List;

public class ConcreteIterator<T> implements Iterator<T>{

    private int position = 0;
    private List<T> elements;

    public ConcreteIterator(List<T> elements) {
        this.elements = elements;
    }
    @Override
    public boolean hasNext() {
        return position < elements.size();
    }

    @Override
    public boolean hasPrevious() {
        return position > 0;
    }

    @Override
    public T next() {
        if (position < 0) {
            position = 0;
        }
        if (hasNext()) {
            return elements.get(position++);
        }
        return null;
    }

    @Override
    public T previous() {
        if (hasPrevious()) {
            return elements.get(--position);
        }
        return null;
    }

    @Override
    public void add(T element) {
        elements.add(position, element);
    }

    @Override
    public void remove() {
        elements.remove(position);
    }
}
