package com.shashank.ps.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This program filters graduates based one whether they have passed, passed with distinction or failed.
 * Streaming and filter logic presents example of streaming both map and list.
 * Sorting logic also present.
 */
public class GraduateFilter {

    private static final double PASS_SCORE = 5.6;
    private static final double DISTINCTION_SCORE = 8.5;

    public static void main(String[] args) {
        List<Graduate> graduates = new ArrayList<>();
        Map<Integer, Graduate> graduateMap = new HashMap<>();
        prepareGraduateList(graduates, graduateMap);

        List<Graduate> passed = graduateMap.entrySet().stream()
                .filter(g -> g.getValue().getGpa() >= PASS_SCORE)
                .sorted(Map.Entry.comparingByValue((g1, g2) -> Integer.compare(g2.getId(), g1.getId())))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        List<Graduate> distinction = graduates.stream()
                .filter(g -> g.getGpa() >= DISTINCTION_SCORE)
                .sorted(Comparator.comparing(Graduate::getGpa))
                .collect(Collectors.toList());

        List<Graduate> failed = graduates.stream()
                .filter(g -> g.getGpa() < PASS_SCORE)
                .sorted(Comparator.comparing(Graduate::getGpa))
                .collect(Collectors.toList());

        System.out.println("Graduates who passed");
        passed.forEach(System.out::println);

        System.out.println("Graduates who passed with distinction");
        distinction.forEach(System.out::println);

        System.out.println("Graduates who failed");
        failed.forEach(System.out::println);
    }

    public static void prepareGraduateList(List<Graduate> graduates, Map<Integer, Graduate> graduateMap) {
        Graduate s1 = new Graduate(2, 8.8, "Sam" );
        Graduate s2 = new Graduate(1, 3.4, "Max" );
        Graduate s3 = new Graduate(4, 4.6, "Bruce" );
        Graduate s4 = new Graduate(3, 7.5, "Peter" );
        Graduate s5 = new Graduate(12, 9.1, "Clark" );
        Graduate s6 = new Graduate(21, 5.8, "Tony" );
        Graduate s7 = new Graduate(11, 6.9, "Rick" );
        Graduate s8 = new Graduate(15, 8.1, "Nat" );
        Graduate s9 = new Graduate(18, 8.5, "Nicky" );

        graduates.add(s1);
        graduates.add(s2);
        graduates.add(s3);
        graduates.add(s4);
        graduates.add(s5);
        graduates.add(s6);
        graduates.add(s7);
        graduates.add(s8);
        graduates.add(s9);

        graduateMap.putIfAbsent(s1.getId(), s1);
        graduateMap.putIfAbsent(s2.getId(), s2);
        graduateMap.putIfAbsent(s3.getId(), s3);
        graduateMap.putIfAbsent(s4.getId(), s4);
        graduateMap.putIfAbsent(s5.getId(), s5);
        graduateMap.putIfAbsent(s6.getId(), s6);
        graduateMap.putIfAbsent(s7.getId(), s7);
        graduateMap.putIfAbsent(s8.getId(), s8);
        graduateMap.putIfAbsent(s9.getId(), s9);
    }
}

@Getter
@Setter
@AllArgsConstructor
class Graduate {
    private int id;
    private double gpa;
    private String name;

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

