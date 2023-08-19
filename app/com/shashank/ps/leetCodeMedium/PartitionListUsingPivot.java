package com.shashank.ps.leetCodeMedium;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 *
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */
public class PartitionListUsingPivot {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        head = partition(head, 3);
        System.out.println(head.val + " -- " + head.next.val + " -- " + head.next.next.val + " -- " + head.next.next.next.val + " -- " + head.next.next.next.next.val + " -- " + head.next.next.next.next.next.val + "");
    }

    private static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode smaller = head.val < x ? head: null;
        ListNode greater = head.val >= x ? head: null;

        ListNode temp =head.next;
        ListNode greaterStart = greater;

        while (temp != null) {
            if (temp.val < x) {
                if (smaller == null) {
                    smaller = temp;
                    head = smaller;
                } else {
                    smaller.next = temp;
                    smaller = smaller.next;
                }
            } else {
                if (greater == null) {
                    greater = temp;
                    greaterStart = greater;
                } else {
                    greater.next = temp;
                    greater = greater.next;
                }
            }
            temp = temp.next;
        }

        if (greater != null) {
            greater.next = null;
        }

        if (smaller == null) {
            head = greaterStart;
        } else {
            smaller.next = greaterStart;
        }
        return head;
    }
}
