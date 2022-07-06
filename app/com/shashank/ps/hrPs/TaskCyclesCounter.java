package com.shashank.ps.hrPs;

/*
Given a list of tasks and a cooldown to be respected for the same type of task, calculate how long it would take you to run the entire list of tasks, assuming each task takes one cycle.

Example:
tasks = [5, 5, 3, 3, 5]
cooldown = 2
execution plan = [5, _, _, 5, 3, _, _, 3, 5]
output = 9

1 + 2 + 1 + 2

tasks = [1, 2, 3, 1]
cooldown = 2
execution plan = [1, 2, 3, 1]


tasks = []
cooldown = 2
execution plan = []
output = 0
*/


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TaskCyclesCounter {
    public static void main(String[] args) {
        List<Integer> tasks = Arrays.asList(5, 5, 3, 3, 5);
        //List<Integer> tasks = Arrays.asList(1,2,3,1);
        int coolDown = 3;
        System.out.println(getExecutionPlan(tasks, coolDown));
    }

    static int getExecutionPlan(List<Integer> tasks, int coolDown) {
        if (tasks == null) {
            return 0;
        }
        int size = tasks.size();
        if (size <= 1) {
            return size;
        }

        if (coolDown <= 0) {
            return size;
        }

        int result = 1;
        Map<Integer, Integer> counters = new HashMap<>();
        counters.put(tasks.get(0), 0);
        int counter = 1;

        while (counter < size) {
            if ((!counters.containsKey(tasks.get(counter)))  ||
                    (counters.containsKey(tasks.get(counter)) && (result - coolDown) > counters.get(tasks.get(counter)))) {
                counters.put(tasks.get(counter), result);
                counter++;
            }
            result ++;
        }


        return result;
    }
}

