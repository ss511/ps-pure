package com.shashank.ps.leetCodeMedium;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 *
 * Example:
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 */
public class SortedListToHeightBalancedBST {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        ConvertSortedListToBST convertSortedListToBST = new ConvertSortedListToBST();
        TreeNode root = convertSortedListToBST.sortedListToBST(head);
        System.out.println(root.val + " -- " + root.left.val + " -- " + root.right.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }

class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val, null, null);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        prev.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
