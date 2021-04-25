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

        SinglyList reverseListIterative = listReverse.reverseIterative(singlyList);

        System.out.println("List after reversing using iterative method...");
        listActions.print(reverseListIterative);

        SinglyList reverseListRecursive = listReverse.reverseRecursive(reverseListIterative, reverseListIterative, null);

        System.out.println("List after reversing using recursive method...");
        listActions.print(reverseListRecursive);

    }

    public SinglyList reverseIterative(SinglyList singlyList) {

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

    public SinglyList reverseRecursive(SinglyList head, SinglyList curr, SinglyList prev) {

        if (head == null) {
            return head;
        }
        if (curr.getNext() == null) {
            head = curr;
            curr.setNext(prev);
            return head;
        }

        SinglyList nextNode = curr.getNext();
        curr.setNext(prev);
        head = reverseRecursive(head, nextNode, curr);

        return head;
    }
}
