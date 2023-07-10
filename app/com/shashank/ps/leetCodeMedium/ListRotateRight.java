package com.shashank.ps.leetCodeMedium;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example
 *
 * 1,2,3,4,5 and k = 2 -> 4,5,1,2,3
 *
 * 0,1,2 and k = 4 -> 2,0,1
 */
public class ListRotateRight {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);

        ListNode newList1 = rotateRight(listNode1, 2);

        while(newList1 != null) {
            System.out.print(newList1.val + " ");
            newList1 = newList1.next;
        }
        System.out.println();

        ListNode listNode2 = new ListNode(0);
        listNode2.next = new ListNode(1);
        listNode2.next.next = new ListNode(2);

        ListNode newList2 = rotateRight(listNode2, 4);

        while(newList2 != null) {
            System.out.print(newList2.val + " ");
            newList2 = newList2.next;
        }
    }

    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode temp = head;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        temp.next = head;

        k = k%len;
        k = len-k;
        int i = 0;

        ListNode prev = head;
        ListNode curr = head.next;
        while (i < k-1 && curr.next != null) {
            prev = prev.next;
            curr = curr.next;
            i++;
        }

        head = curr;
        prev.next = null;
        return head;
    }
}
