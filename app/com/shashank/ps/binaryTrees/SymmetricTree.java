package com.shashank.ps.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Program which finds out if the tree is symmetric or not. The left half must mirror the right half.
 * Values of the node can be different.
 */
public class SymmetricTree {

    public static void main(String[] args) {
        BinaryTree treeUtils = new BinaryTree();
        Tree root = treeUtils.insert(20, null);
        treeUtils.insert(10, root);
        treeUtils.insert(5, root);
        treeUtils.insert(1, root);
        treeUtils.insert(25, root);
        treeUtils.insert(100, root);
        treeUtils.insert(40, root);

        System.out.println("Is the tree Symmetric: " + isSymmetric(root));
        System.out.println("Is the tree mirror: " + isSymmetricAndMirror(root));
    }

    private static boolean isSymmetric(Tree root) {

        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return true;
        }

        List<Integer> leftTreeList = leftTraverse(root.getLeft(), new ArrayList<>());
        List<Integer> rightTreeList = rightTraverse(root.getRight(), new ArrayList<>());

        int leftTreeListSize = leftTreeList.size();

        if (leftTreeListSize != rightTreeList.size()) {
            return false;
        }

        for (int i = 0; i < leftTreeListSize; i++) {
            if (leftTreeList.get(i).equals(rightTreeList.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> leftTraverse(Tree node, List<Integer> directions) {
        if (node == null) {
            return directions;
        }
        if (node.getLeft() != null) {
            directions.add(0);
        }
        if (node.getRight() != null) {
            directions.add(1);
        }
        leftTraverse(node.getLeft(), directions);
        leftTraverse(node.getRight(), directions);
        return directions;
    }

    private static List<Integer> rightTraverse(Tree node, List<Integer> directions) {
        if (node == null) {
            return directions;
        }
        if (node.getLeft() != null) {
            directions.add(1);
        }
        if (node.getRight() != null) {
            directions.add(0);
        }
        rightTraverse(node.getLeft(), directions);
        rightTraverse(node.getRight(), directions);
        return directions;
    }

    //Below methods will work if tree is symmetric and perfect mirror image of left and right.

    private static boolean isSymmetricAndMirror(Tree root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(Tree node1, Tree node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 != null && node2 != null && node1.getData() == node2.getData()) {
            return isMirror(node1.getLeft(), node2.getRight()) && isMirror(node1.getRight(), node2.getLeft());
        }
        return false;
    }
}
