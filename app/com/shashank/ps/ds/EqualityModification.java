package com.shashank.ps.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualityModification {

    public static void main (String[] args) {
        Kids k1 = new Kids(1, "Sam", 90);
        Kids k2 = new Kids(2, "Max", 90);
        Kids k3 = new Kids(1, "Sam", 90);
        Kids k4 = new Kids(1, "Sam", 85);
        Kids k5 = new Kids(3, "Peter", 70);
        Kids k6 = new Kids(3, "Peter", 80);
        Kids k7 = new Kids(2, "Amy", 80);

        System.out.println(k1.equals(k2));
        System.out.println(k1.equals(k3));
        System.out.println(k1.equals(k4));

        Set<Kids> set = new HashSet<>();
        set.add(k1);
        set.add(k2);

        System.out.println(set.contains(k3));

        List<Kids> kidsList = new ArrayList<>();
        kidsList.add(k1);
        kidsList.add(k2);
        kidsList.add(k3);
        kidsList.add(k4);
        kidsList.add(k5);
        kidsList.add(k6);
        kidsList.add(k7);


        kidsList.sort((o1, o2) -> {
            if (o1.getId() != o2. getId()) {
                return o1.getId() - o2.getId();
            } else if (!o1.getName().equals(o2.getName())) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return o2.getMarks() - o1.getMarks();
            }
        });

//        kidsList.sort(new KidsComparator());

        kidsList.forEach(System.out::println);
    }
}

@Getter
@Setter
@AllArgsConstructor
class Kids {
    private int id;
    private String name;
    private int marks;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Kids)) {
            return false;
        }
        Kids k = (Kids) o;

        return id == k.id && name.equals(k.name) && marks == k.marks;
    }

    @Override
    public int hashCode() {
        int hash = id;
        hash = 51 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 51 * hash + this.marks;
        return hash;
    }

    @Override
    public String toString() {
        return "ID: " +  id + ", Name: " + name + ", Marks: " + marks;
    }
}

//class KidsComparator implements Comparator<Kids> {
//
//    @Override
//    public int compare(Kids o1, Kids o2) {
//        if (o1.getId() != o2. getId()) {
//            return o1.getId() - o2.getId();
//        } else if (!o1.getName().equals(o2.getName())) {
//            return o1.getName().compareTo(o2.getName());
//        } else {
//            return o2.getMarks() - o1.getMarks();
//        }
//    }
//}