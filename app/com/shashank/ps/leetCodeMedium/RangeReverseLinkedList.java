package com.shashank.ps.leetCodeMedium;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Example1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 *
 * Example 3:
 * Input: head = [3,5], left = 1, right = 2
 * Output: [5,3]
 */
public class RangeReverseLinkedList {
    public static void main(String[] arg) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);

        ListNode newNode = reverseBetween(listNode1, 2, 4);
        while(newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode temp = head;
        ListNode prev = null;

        for (int i = 1; i < left; i++) {
            prev = temp;
            temp = temp.next;
        }

        ListNode next = null;
        ListNode curr = temp;
        ListNode tail = temp;
        ListNode prevOfCurr = null;

        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prevOfCurr;
            prevOfCurr = curr;
            curr = next;
        }

        if (prev != null) {
            prev.next = prevOfCurr;
        } else {
            head = prevOfCurr;
        }
        tail.next = curr;

        return head;
    }
}
