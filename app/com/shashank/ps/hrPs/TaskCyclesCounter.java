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


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TaskCyclesCounter {
    public static void main(String[] args) {
        System.out.println("Hello, World");
        //List<Integer> tasks = Arrays.asList(5, 5, 3, 3, 5);
        List<Integer> tasks = Arrays.asList(1,2,3,1);
        System.out.println(getExecutionPlan(tasks, 2));
    }

    static int getExecutionPlan(List<Integer> tasks, int cooldown) {
        if ( cooldown <= 0 ) { return tasks.size(); }

        Map<Integer, Integer> lastTimeSlot = new HashMap<>();
        int result = 0;
        int taskIndex = 0;

        while ( taskIndex < tasks.size() ) {
            Integer task = tasks.get(taskIndex);
            Integer last = lastTimeSlot.get(task);
            if ( last == null || result - last > cooldown ) {
                lastTimeSlot.put(task, result);
                taskIndex++;
            }
            result++;
        }

        return result;
    }
}

