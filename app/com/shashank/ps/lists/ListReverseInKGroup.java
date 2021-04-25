package com.shashank.ps.lists;

import com.shashank.ps.lists.singlyLists.ListActions;
import com.shashank.ps.lists.singlyLists.SinglyList;

/**
 * Program to reverse a Singly Linked List.
 */
public class ListReverseInKGroup {

    public static void main(String[] args) {
        ListReverseInKGroup listReverse = new ListReverseInKGroup();
        ListActions listActions = new ListActions(null);
        listActions.add(5);
        listActions.add(1);
        listActions.add(10);
        listActions.add(15);
        listActions.add(12);
        listActions.add(11);
        listActions.add(312);
        listActions.add(121);
        listActions.add(921);
        listActions.add(7821);
        SinglyList singlyList = listActions.add(20);

        System.out.println("Original List...");
        listActions.print(singlyList);

        SinglyList reverseList = listReverse.reverse(singlyList, 3);

        System.out.println("List after reversing in k groups...");
        listActions.print(reverseList);

    }

    public SinglyList reverse(SinglyList head, int k) {

        if (head == null) {
            return head;
        }
        int count = 0;

        SinglyList curr = head;
        SinglyList prev = null;
        SinglyList next = null;
        while (curr != null && count < k) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count ++;
        }

        if (next != null) {
            head.setNext(reverse(curr, k));
        }
        return prev;
    }
}
