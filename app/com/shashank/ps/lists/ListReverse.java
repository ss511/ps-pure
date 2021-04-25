package com.shashank.ps.lists;

import com.shashank.ps.lists.singlyLists.ListActions;
import com.shashank.ps.lists.singlyLists.SinglyList;

/**
 * Program to reverse a Singly Linked List.
 */
public class ListReverse {

    public static void main(String[] args) {
        ListReverse listReverse = new ListReverse();
        ListActions listActions = new ListActions(null);
        listActions.add(5);
        listActions.add(1);
        listActions.add(10);
        listActions.add(15);
        listActions.add(12);
        SinglyList singlyList = listActions.add(20);

        System.out.println("Original List...");
        listActions.print(singlyList);

        SinglyList reverseList = listReverse.getReverse(singlyList);

        System.out.println("List after reversing...");
        listActions.print(reverseList);

    }

    public SinglyList getReverse(SinglyList singlyList) {

        SinglyList prev = null;
        SinglyList curr = singlyList;
        SinglyList next;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
