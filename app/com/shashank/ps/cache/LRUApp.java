package com.shashank.ps.cache;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUApp {

    public static void main (String[] args) throws IOException {
        int option;

        LRU lru = new LRU(3);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Choose Option\n" +
                    "1. Add Key\n" +
                    "2. Get Key\n" +
                    "3. Display Cache\n" +
                    "4. Exit");

            option = Integer.parseInt(br.readLine());

            switch (option) {
                case 1:
                    System.out.println("Add Key");
                    int key = Integer.parseInt(br.readLine());
                    lru.refer(key);
                    break;
                case 2:
                    System.out.println("Get Key");
                    key = Integer.parseInt(br.readLine());
                    System.out.println("Key Present: " + lru.get(key));
                    break;
                case 3:
                    System.out.println("Cache Contents Are: \n");
                    lru.cacheDisplay();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Termination Application...");
                    break;
                default:
                    System.out.println("Enter Correct Option.");
                    break;

            }
        } while (option != 4);
    }

}

/**
 * LRU DS and Implementation.
 * Maintains LinkedHashSet (LinkedHashMap too will work for key-value pair) for LRU Cache.
 * Other ways can be to have hashset and a queue with doubly linked list implementation.
 */
class LRU {

    private final Set<Integer> cache;
    private final int capacity;

    public LRU (int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashSet<>(capacity);
    }

    public boolean get (int key) {
        if (!cache.contains(key)) {
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }

    public void refer (int key) {
        if (!get(key)) {
            put(key);
        }
    }

    public void put (int key) {
        if (cache.size() == capacity) {
            cache.remove(cache.iterator().next());
        }
        cache.add(key);
    }

    public void cacheDisplay () {
        for (Integer integer : cache) {
            System.out.print(integer + "\t");
        }
    }
}