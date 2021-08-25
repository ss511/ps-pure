package com.shashank.ps.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class orders students based on their marks and roll numbers.
 */
public class RankOrdering {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        prepareStudentList(students);

        //This will sort and add to a new list.
        List<Student> sortedList = students.stream()
                .sorted((a,b) -> {
                    if (a.getMarks() == b.getMarks()) {
                        return Integer.compare(a.getRollNum(), b.getRollNum());
                    } else {
                        return Integer.compare(b.getMarks(), a.getMarks());
                    }}
                ).collect(Collectors.toList());

        //This will sort the original list itself but based on roll num and rank order.
        students.sort(Comparator.comparing(Student::getRollNum));

        //Printing both lists.
        //The new List which is sorted based on higher marks first.
        System.out.println(sortedList);

        //The original List which is sorted based on roll number starting from lower number.
        students.forEach(System.out::println);
    }

    public static void prepareStudentList(List<Student> students) {
        Student s1 = new Student(2, 60, "Sam" );
        Student s2 = new Student(1, 50, "Max" );
        Student s3 = new Student(4, 66, "Bruce" );
        Student s4 = new Student(3, 66, "Peter" );
        Student s5 = new Student(12, 60, "Clark" );
        Student s6 = new Student(21, 40, "Tony" );
        Student s7 = new Student(11, 90, "Rick" );
        Student s8 = new Student(15, 40, "Nat" );
        Student s9 = new Student(18, 80, "Nicky" );

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);
    }

}


@Getter
@Setter
@AllArgsConstructor
class Student {
    private int rollNum;
    private int marks;
    private String name;

    @Override
    public String toString() {
        return "Roll number: " + rollNum + ", Name: " + name + ", Marks: " + marks + "\n";
    }
}