package com.shashank.ps.lists;

import com.shashank.ps.lists.singlyLists.ListActions;
import com.shashank.ps.lists.singlyLists.SinglyList;

/**
 * Performs merge sort for the linked list.
 */
public class ListMergeSort {

    ListMiddleNode listMiddleNode = new ListMiddleNode();

    public static void main(String[] args) {

        ListActions listActions = new ListActions(null);
        listActions.add(5);
        listActions.add(1);
        listActions.add(10);
        listActions.add(15);
        listActions.add(12);
        SinglyList singlyList = listActions.add(20);

        System.out.println("Original List...");
        listActions.print(singlyList);

        ListMergeSort listMergeSort = new ListMergeSort();

        SinglyList sortedList = listMergeSort.mergeSort(singlyList);

        System.out.println("Sorted List...");
        listActions.print(sortedList);

    }

    /**
     * Divides the list into half recursively.
     * @param head - the head node of the list to be sorted.
     * @return - sorted halves.
     */
    public SinglyList mergeSort(SinglyList head) {

        if (head == null || head.getNext() == null) {
            return head;
        }

        SinglyList left = head;
        SinglyList middle = listMiddleNode.getMiddleNode(left);
        SinglyList temp = head;
        while (temp.getNext() != middle) {
            temp = temp.getNext();
        }
        temp.setNext(null);

        SinglyList right = middle;

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    /**
     * Merges two halves into one after sorting it.
     * @param left - Left half of the list.
     * @param right - Right half of the list.
     * @return - sorted merged list.
     */
    public SinglyList merge(SinglyList left, SinglyList right) {
        SinglyList newNode = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.getData() < right.getData()) {
            newNode = left;
            newNode.setNext(merge(left.getNext(), right));
        } else {
            newNode = right;
            newNode.setNext(merge(left, right.getNext()));
        }
        return newNode;
    }
}
