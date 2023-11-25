package com.shashank.ps.designPatterns.iterator;

public class Solution {
    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.add("Apple");
        aggregate.add("Mango");
        aggregate.add("Banana");

        Iterator<String> it = aggregate.createIterator();

        while(it.hasNext()) {
            String currItem = it.next();
            System.out.println(currItem);
            if (currItem.equals("Mango")) {
                it.add("Orange");
            }
        }

        System.out.println("-----------");

        while(it.hasPrevious()) {
            String prevItem = it.previous();
            System.out.println(prevItem);
            if (prevItem.equals("Banana")) {
                it.remove();
            }
        }

        System.out.println("-----------");

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
