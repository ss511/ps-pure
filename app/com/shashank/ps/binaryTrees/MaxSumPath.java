package com.shashank.ps.binaryTrees;

/**
 * Program to find the max sum path in a binary tree.
 */
public class MaxSumPath {

    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTree treeUtils = new BinaryTree();
        Tree root = treeUtils.insert(20, null);
        treeUtils.insert(50, root);
        treeUtils.insert(5, root);
        treeUtils.insert(1, root);
        treeUtils.insert(25, root);
        treeUtils.insert(100, root);
        treeUtils.insert(40, root);
        treeUtils.insert(50, root);
        treeUtils.insert(200, root);

        calculateNodeSum(root);
        System.out.println("The max sum path in the binary tree is: " + maxSum);
    }

    private static int calculateNodeSum(Tree node) {

        if (node == null) {
            return 0;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return node.getData();
        }

        int leftSum = calculateNodeSum(node.getLeft());
        int rightSum = calculateNodeSum(node.getRight());
        int tempMax = Math.max(Math.max(leftSum, rightSum) + node.getData(), node.getData());
        int subTreeSum = leftSum + rightSum + node.getData();
        maxSum = Math.max(maxSum, subTreeSum);
        return tempMax;
    }
}
