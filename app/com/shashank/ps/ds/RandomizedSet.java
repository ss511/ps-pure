package com.shashank.ps.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    public static void main(String[] args) {
        RandomSet randomSet = new RandomSet(new ArrayList<>(), new HashMap<>());
        RandomSetImpl randomSetImpl = new RandomSetImpl(randomSet);

        randomSetImpl.add(1);
        randomSetImpl.add(3);
        randomSetImpl.add(4);
        randomSetImpl.add(12);
        randomSetImpl.add(11);
        randomSetImpl.add(1112);

        System.out.println("Is 11 present: " + randomSetImpl.search(11));
        randomSetImpl.remove(11);
        System.out.println("Is 11 present: " + randomSetImpl.search(11));

        System.out.println("Is 1112 present: " + randomSetImpl.search(1112));
        randomSetImpl.remove(1112);
        System.out.println("Is 1112 present: " + randomSetImpl.search(1112));

        System.out.println("Is 1 present: " + randomSetImpl.search(1));
        randomSetImpl.remove(1);
        System.out.println("Is 1 present: " + randomSetImpl.search(1));

        System.out.println("Is 4 present: " + randomSetImpl.search(4));
        randomSetImpl.remove(4);
        System.out.println("Is 4 present: " + randomSetImpl.search(4));

        System.out.println("---------------------------------------------------------------");
        System.out.println("Random number from the collection: " + randomSetImpl.getRandom());
        System.out.println("Random number from the collection: " + randomSetImpl.getRandom());
        System.out.println("Random number from the collection: " + randomSetImpl.getRandom());
        System.out.println("Random number from the collection: " + randomSetImpl.getRandom());
        System.out.println("Random number from the collection: " + randomSetImpl.getRandom());
    }
}

@Getter
@Setter
@AllArgsConstructor
class RandomSet {
    private List<Integer> items;
    private Map<Integer, Integer> hash;
}

@AllArgsConstructor
class RandomSetImpl {

    private RandomSet randomSet;

    public void add(int x) {
        if (randomSet.getHash().containsKey(x)) {
            return;
        }
        int size = randomSet.getItems().size();
        randomSet.getItems().add(x);
        randomSet.getHash().put(x, size);
    }

    public void remove(int x) {
        if (!randomSet.getHash().containsKey(x)){
            return;
        }
        int index = randomSet.getHash().get(x);
        randomSet.getHash().remove(x);
        int lastIndex = randomSet.getItems().size()-1;
        int last = randomSet.getItems().get(lastIndex);

        if (lastIndex != index) {
            Collections.swap(randomSet.getItems(), index, lastIndex);
            randomSet.getHash().put(last, index);
        }

        randomSet.getItems().remove(lastIndex);
    }

    public boolean search(int x) {
        return randomSet.getHash().containsKey(x);
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(randomSet.getItems().size());
        return randomSet.getItems().get(index);
    }
}
