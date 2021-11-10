package com.shashank.ps.binaryTrees;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This program creates a binary tree from preOrder and inOrder array. Reverse Engineering.
 * Uses AtomicInteger for incrementing.
 */
public class ReverseConstructTrees {
    static Map<Integer,Integer> mp = new HashMap<>();
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};

        TreeNode root = buildTreeWrap(pre, in);
        printPreOrder(root);
        System.out.println();
        printInorder(root);
    }

    private static TreeNode constructBinaryTree(int[] pre, int[] in, int inStart, int inEnd, AtomicInteger preIndex) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex.getAndIncrement()]);
        if (inStart == inEnd) {
            return root;
        }
        int index = mp.get(root.val);
        root.left = constructBinaryTree(pre, in, inStart, index-1, preIndex);
        root.right = constructBinaryTree(pre, in, index+1, inEnd, preIndex);

        return root;
    }

    private static TreeNode buildTreeWrap(int[] pre, int[] in) {
        for(int i = 0; i < in.length; i++)
        {
            mp.put(in[i], i);
        }
        return constructBinaryTree(pre, in, 0, in.length - 1, new AtomicInteger(0));
    }


    private static void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "  ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    private static void printInorder(TreeNode node) {
        if(node == null)
        {
            return;
        }
        printInorder(node.left);
        System.out.print(node.val + "  ");
        printInorder(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}