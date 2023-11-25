package com.shashank.ps.designPatterns.iterator;

public interface Aggregate<T> {
    Iterator<T> createIterator();
}
