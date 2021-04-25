package com.shashank.ps.lists;

import com.shashank.ps.lists.singlyLists.ListActions;
import com.shashank.ps.lists.singlyLists.SinglyList;

/**
 * Program to find middle element of the linked list.
 */
public class ListMiddleNode {

    public static void main(String[] args) {

        ListMiddleNode listMiddleNode = new ListMiddleNode();
        ListActions listActions = new ListActions(null);
        listActions.add(5);
        listActions.add(1);
        listActions.add(10);
        listActions.add(15);
        listActions.add(12);
        SinglyList singlyList = listActions.add(20);

        SinglyList middleNode = listMiddleNode.getMiddleNode(singlyList);

        System.out.println("Middle Element::: " + middleNode.getData());
    }

    public SinglyList getMiddleNode(SinglyList list) {

        SinglyList slow = list;
        SinglyList fast = list;

        while (fast != null) {
            fast = fast.getNext();
            if (fast!= null) {
                fast = fast.getNext();
                slow = slow.getNext();
            }
        }

        return slow;
    }
}
