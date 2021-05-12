package com.shashank.ps.cache;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LFUApp {

    public static void main (String[] args) throws IOException {
        int option;

        LFU lru = new LFU(3);
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
 * Makes use of HashMap containing key and counter and other HashMap containing counter as key and a linked hash set of corresponding user keys.
 * O(1) time complexity for insertion and search.
 */
@Getter
class LFU {

    private final Map<Integer, LinkedHashSet<Integer>> counter;
    private final Map<Integer, Integer> cache;
    private final int capacity;
    private int minimum;

    public LFU (int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        counter = new HashMap<>(capacity);
        counter.put(1, new LinkedHashSet<>());
        minimum = -1;
    }

    public boolean get (int key) {
        if (cache.containsKey(key)) {
            int fetchCount = cache.get(key);
            cache.replace(key, fetchCount+1);
            counter.get(fetchCount).remove(key);

            if (fetchCount == minimum && counter.get(fetchCount).size() == 0) {
                minimum++;
            }
            if (!counter.containsKey(fetchCount+1)) {
                counter.put(fetchCount+1, new LinkedHashSet<>());
            }
            counter.get(fetchCount+1).add(key);
            return true;
        }
        return false;
    }

    public void refer (int key) {
        if (!get(key)) {
            put (key);
        }
    }

    private void put (int key) {

        if (cache.size() >= capacity) {
            int keyToRemove = counter.get(minimum).iterator().next();
            cache.remove(keyToRemove);
            counter.get(minimum).remove(keyToRemove);
        }
        cache.put(key, 1);
        minimum = 1;
        counter.get(minimum).add(key);
    }

    public void cacheDisplay () {
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            System.out.print(entry.getKey() + "\t");
        }
    }
}