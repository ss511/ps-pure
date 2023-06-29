package com.shashank.ps.leetCodeMedium;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 * For example:
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 */
public class RootToLeafSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        RootToLeafSumSolution rootToLeafSumSolution = new RootToLeafSumSolution();
        System.out.println(rootToLeafSumSolution.sumNumbers(treeNode));
    }
}

class RootToLeafSumSolution {

    public int sumNumbers(TreeNode root) {
        return traverse(root, 0, 0);
    }

    private int traverse(TreeNode root, int sum, int totalSum) {
        if (root.left == null && root.right == null) {
            totalSum += (sum*10) + root.val;
            return totalSum;
        }
        sum = (sum*10) + root.val;
        if (root.left != null)
            totalSum = traverse(root.left, sum, totalSum);
        if (root.right != null)
            totalSum = traverse(root.right, sum, totalSum);
        return totalSum;

    }
}