package com.shashank.ps.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectionBasics {

    public static void main(String[] args) {
        System.out.println("******************** Array Lists ********************");
        arrayLists();
        System.out.println("\n******************** Linked Lists ********************");
        linkedLists();
        System.out.println("\n******************** Sets ********************");
        sets();
        System.out.println("\n******************** Maps ********************");
        maps();
        System.out.println("\n******************** Stacks ********************");
        stacks();
        System.out.println("\n******************** Queues ********************");
        queues();
    }

    private static void arrayLists() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(15);
        list.add(12);

        list.forEach(i -> System.out.print(i + " "));
        System.out.println();
        list.remove(3);
        list.forEach(i -> System.out.print(i + " "));
        System.out.println("\nGet: " + list.get(5));
        System.out.println("Contains: " + list.contains(3) + " || " + list.contains(120));
        System.out.println("Index Of: " + list.indexOf(2) + " || " + list.indexOf(120));
        List<Integer> anotherList = Arrays.asList(200, 300, 150, 100);
        list.addAll(anotherList);
        list.forEach(i -> System.out.print(i + " "));
        list.sort((a,b) -> Integer.compare(b, a));
        System.out.println("\nReverse Sorting: ");
        list.forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static void linkedLists() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(3);
        list.add(15);
        list.add(12);

        Iterator<Integer> iterator = list.descendingIterator();
        System.out.println("Printing in reverse order.");
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        ListIterator<Integer> normalIt = list.listIterator(3);
        System.out.println("\nPrinting backwards from index 3.");
        while(normalIt.hasPrevious()) {
            System.out.print(normalIt.previous() + " ");
        }
        System.out.println();
        list.forEach(i -> System.out.print(i + " "));
        System.out.println();
        list.remove(3);
        list.forEach(i -> System.out.print(i + " "));
        System.out.println("\nGet: " + list.get(5));
        System.out.println("Contains: " + list.contains(3) + " || " + list.contains(120));
        System.out.println("Index Of: " + list.indexOf(2) + " || " + list.indexOf(120));
        List<Integer> anotherList = Arrays.asList(200, 300, 150, 100);
        list.addAll(anotherList);
        list.forEach(i -> System.out.print(i + " "));
        list.sort((a,b) -> Integer.compare(b, a));
        System.out.println("\nReverse Sorting: ");
        list.forEach(i -> System.out.print(i + " "));

    }

    private static void sets() {
        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(1);
        System.out.println("Contains: " + set.contains(2) + " || " + set.contains(4));
        set.add(5);
        set.remove(3);
        System.out.println("Adding 2 " + set.add(2));
        System.out.println("Adding 11 " + set.add(11));
        System.out.println("Removing 8 " + set.remove(8));
        set.forEach(i -> System.out.print(i + " "));
        Iterator<Integer> it = set.iterator();
        System.out.println("\nFirst Fetch: " + it.next());

        System.out.println("Tree Set::");
        Set<Integer> treeSet = new TreeSet<>(set);
        treeSet.forEach(i -> System.out.print(i + " "));

        LinkedHashSet<Integer> reverseSortedSet = set.stream()
                .sorted((a,b) -> b-a)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("\nSorted Reverse Linked Hash Set::");
        reverseSortedSet.forEach(i -> System.out.print(i + " "));
    }

    private static void maps() {
        Map<Integer, CricketPlayers> players = new HashMap<>();
        players.put(3, new CricketPlayers(3, "Sam", 500));
        players.put(6, new CricketPlayers(6, "Albert", 200));
        players.put(1, new CricketPlayers(1, "Tom", 200));
        players.put(9, new CricketPlayers(9, "Max", 600));
        players.put(8, new CricketPlayers(8, "Max", 600));
        players.putIfAbsent(4,new CricketPlayers(4, "Sam", 500));

        for (Map.Entry<Integer, CricketPlayers> entry: players.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getRuns());
        }

        Map<Integer, CricketPlayers> sortedPlayers = new TreeMap<>(players);
        System.out.println("Tree Map");
        for (Map.Entry<Integer, CricketPlayers> entry: sortedPlayers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getRuns());
        }
        Map<Integer, CricketPlayers> linkedPlayers = new LinkedHashMap<>();
        linkedPlayers.put(3, new CricketPlayers(3, "Sam", 500));
        linkedPlayers.put(6, new CricketPlayers(6, "Albert", 200));
        linkedPlayers.put(1, new CricketPlayers(1, "Tom", 200));
        linkedPlayers.put(9, new CricketPlayers(9, "Max", 600));
        linkedPlayers.put(8, new CricketPlayers(8, "Max", 600));

        System.out.println("Linked Map");
        for (Map.Entry<Integer, CricketPlayers> entry: linkedPlayers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getRuns());
        }

        Map<Integer, CricketPlayers> sortedCrickets = players.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((a,b) -> {
                    if (a.getRuns() != b.getRuns()) {
                        return b.getRuns() - a.getRuns();
                    } else if (!(a.getName().equals(b.getName()))) {
                        return a.getName().compareTo(b.getName());
                    } else {
                        return a.getId() - b.getId();
                    }
                }))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, newVal) -> old, LinkedHashMap::new));


        System.out.println("Sorted Map");
        for (Map.Entry<Integer, CricketPlayers> entry: sortedCrickets.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " + entry.getValue().getRuns());
        }
    }

    private static void stacks() {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(6);
        stack.push(1);
        stack.push(7);
        System.out.println("Top: " + stack.peek());
        System.out.println("Poll: " + stack.pop());
        System.out.println("Remove: " + stack.remove(0));
        System.out.println("Contains: " + stack.contains(6));

        String a = "Hello World";
        Stack<String> characters = new Stack<>();
        characters.addAll(Arrays.asList(a.split("")));
        StringBuilder reverseSb = new StringBuilder();
        while (!characters.isEmpty()) {
            reverseSb.append(characters.pop());
        }
        System.out.println("Reverse String is: " + reverseSb);
    }

    private static void queues() {
        Queue<CricketPlayers> players = new LinkedList<>();
        players.add(new CricketPlayers(3, "Sam", 500));
        players.add(new CricketPlayers(6, "Albert", 200));
        players.add(new CricketPlayers(1, "Tom", 200));
        players.add(new CricketPlayers(9, "Max", 600));
        players.add(new CricketPlayers(8, "Max", 600));

        System.out.println("Printing the Players");
        players.forEach(o -> System.out.println(o.getId() + " " + o.getName() + " " + o.getRuns()));
        assert players.peek() != null;
        System.out.println("Peek: " + players.peek().getName());
        System.out.println("Contains: " + players.contains(new CricketPlayers(3, "Sam", 400)));

        Queue<CricketPlayers> sortedPlayers = players.stream()
                .sorted(Comparator.comparing(CricketPlayers::getRuns, Comparator.reverseOrder())
                        .thenComparing(CricketPlayers::getName)
                        .thenComparing(CricketPlayers::getId))
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("Printing the Sorted Players");
        sortedPlayers.forEach(o -> System.out.println(o.getId() + " " + o.getName() + " " + o.getRuns()));

        System.out.println("Tom".compareTo("Sam"));
        Queue<CricketPlayers> priorityQueue = new PriorityQueue<>(Comparator.comparing(CricketPlayers::getRuns, Comparator.reverseOrder())
                .thenComparing(CricketPlayers::getName)
                .thenComparing(CricketPlayers::getId));
        priorityQueue.addAll(players);
        System.out.println("Printing the Priority Players");
        CricketPlayers pcp;
        while ((pcp = priorityQueue.poll())!= null)
            System.out.println(pcp.getId() + " " + pcp.getName() + " " + pcp.getRuns());
    }
}

@Setter
@Getter
@AllArgsConstructor
class CricketPlayers {
    int id;
    String name;
    int runs;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CricketPlayers)) {
            return false;
        }
        CricketPlayers cp = (CricketPlayers) o;

        return cp.getId() == this.getId() && cp.getName().equals(this.getName()) && cp.getRuns() == this.getRuns();
    }

    @Override
    public int hashCode() {
        int hash = this.id;
        hash += 51*hash + (this.getName().hashCode());
        hash += this.getRuns();
        return hash;
    }
}
