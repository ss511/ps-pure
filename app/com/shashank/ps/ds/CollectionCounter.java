package com.shashank.ps.ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionCounter {

    public static void main(String[] args) {
        String text = "Hi bye how are you will do he she bye with if so how do if so where is then if go to bed hi so how are you all if else if then";

        List<String> texts = Arrays.asList(text.split(" "));

        Map<String, Long> wm = new HashMap<>();
        for (String s : texts) {
            wm.putIfAbsent(s, 1L);
            wm.computeIfPresent(s, (key, val) -> val + 1);
        }

        for (Map.Entry<String, Long> wme : wm.entrySet()) {
            System.out.println(wme.getKey() + " " + wme.getValue());
        }

        //Collects word count in a map.
        Map<String, Long> wordMap = texts.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> sortedWordMap = wordMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new
                ));

        System.out.println("Word Map=======================================");
        wordMap.forEach((key, value) -> {
            System.out.println(key + "  " + value);
        });
        System.out.println("Sorted Word Map =======================================");
        sortedWordMap.forEach((key, value) -> {
            System.out.println(key + "  " + value);
        });

        String maxOccurringWord = wordMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        System.out.println("Word with max count is::: '" + maxOccurringWord + "' with a count of " + wordMap.get(maxOccurringWord));

        List<String> sortedWords = wordMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Sorted Word List in Ascending Order is: ");
        Stream.of(sortedWords).forEach(System.out::println);

    }
}
