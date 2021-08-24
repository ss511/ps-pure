package com.shashank.ps.ds;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberSeqGenerator {

    public static void main(String[] args) {

        int limit = 100;

        IntStream stream = IntStream.iterate(0, i -> i+1).limit(limit);

        List<Integer> even = stream.filter(NumberSeqGenerator::isEven).boxed().collect(Collectors.toList());

        even.forEach(i -> System.out.print(i + " "));
    }

    private static boolean isEven(int n) {
        return n%2 == 0;
    }
}
