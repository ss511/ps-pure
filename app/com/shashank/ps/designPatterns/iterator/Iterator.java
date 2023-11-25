package com.shashank.ps.designPatterns.iterator;

public interface Iterator<T> {

    boolean hasNext();

    boolean hasPrevious();

    T next();

    T previous();

    void add(T element);

    void remove();
}
