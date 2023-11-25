package com.shashank.ps.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate<T> implements Aggregate<T> {

    private final List<T> elements = new ArrayList<>();

    public void add(T element) {
        elements.add(element);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(elements);
    }
}
