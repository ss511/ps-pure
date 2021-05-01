package com.shashank.ps.binaryTrees;

/**
 * Program to check if two nodes are cousins or not. Don't confuse it with sibling node.
 * Two nodes having same parent are siblings and not cousins.
 */
public class CousinsNode {

    public static void main(String[] args) {
        BinaryTree treeUtils = new BinaryTree();
        Tree root = treeUtils.insert(20, null);
        treeUtils.insert(10, root);
        treeUtils.insert(5, root);
        treeUtils.insert(1, root);
        treeUtils.insert(25, root);
        treeUtils.insert(100, root);
        treeUtils.insert(40, root);
        treeUtils.insert(50, root);
        treeUtils.insert(200, root);

        int data1 = 40;
        int data2 = 25;

        try {
            System.out.println(data1 + " and " + data2 + " are cousins: " + areCousins(root, data1, data2));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static boolean areCousins(Tree root, int data1, int data2) {

        int data1Level = dataLevel(root, data1, 1);
        int data2Level = dataLevel(root, data2, 1);

        if (data1Level == 0 || data2Level == 0) {
            throw new IllegalArgumentException("One or both node not present in the tree.");
        }

        if (data1Level != data2Level) {
            return false;
        } else {
            return !areSiblings(root, data1, data2);
        }
    }

    private static int dataLevel(Tree root, int data, int level) {
        if (root == null) {
            return 0;
        }

        if (root.getData() == data) {
            return level;
        }

        int downLevel = dataLevel(root.getLeft(), data, level+1);
        if (downLevel == 0) {
            downLevel = dataLevel(root.getRight(), data, level+1);
        }
        return downLevel;
    }

    private static boolean areSiblings(Tree root, int data1, int data2) {

        if (root == null) {
            return false;
        }
        if (root.getLeft() == null || root.getRight() == null) {
            return false;
        }
        int leftData = root.getLeft().getData();
        int rightData = root.getRight().getData();


        if ((leftData == data1 && rightData == data2)
                || (leftData == data2 && rightData == data1)) {
            return true;
        }
        return areSiblings(root.getLeft(), data1, data2) || areSiblings(root.getRight(), data1, data2);
    }
}
