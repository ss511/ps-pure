package com.shashank.ps.lists;

import com.shashank.ps.lists.singlyLists.ListActions;
import com.shashank.ps.lists.singlyLists.SinglyList;

/**
 * This program segregates odd and even nodes and collects them together.
 * In place(O(1) space complexity) and O(n) time complexity.
 * Example:
 * Original List: 5 -> 1 -> 10 -> 15 -> 12 -> 20
 * Modified List: 5 -> 10 -> 12 -> 1 -> 15 -> 20
 * The odd nodes are placed first and then even nodes.
 */
public class EvenOddNodeSegregation {

    public static void main(String[] args) {
        ListActions listActions = new ListActions(null);
        listActions.add(5);
        listActions.add(1);
        listActions.add(10);
        listActions.add(15);
        listActions.add(12);
        SinglyList singlyList = listActions.add(20);
        System.out.println("Original List");
        listActions.print(singlyList);
        getSegregatedNodes(singlyList);
        System.out.println("Segregated List");
        listActions.print(singlyList);
    }

    private static void getSegregatedNodes(SinglyList head) {
        if (head == null || head.getNext() == null) {
            return;
        }
        SinglyList odd = head;
        SinglyList evenStart = head.getNext();
        SinglyList even = evenStart;
        SinglyList temp = head;
        while (temp.getNext() != null && even.getNext() != null) {
            temp = temp.getNext();
            odd.setNext(even.getNext());
            even.setNext(odd.getNext().getNext());
            if (odd.getNext() != null) {
                odd = odd.getNext();
            }
            if (even.getNext() != null) {
                even = even.getNext();
            }
        }

        odd.setNext(evenStart);
    }
}
