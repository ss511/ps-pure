package com.shashank.ps.binaryTrees;

/**
 * Program to print the binary tree in 2D format.
 */
public class TwoDView {

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

        print2D(root, 1);
    }

    private static void print2D(Tree root, int level) {

        if (root == null) {
            return;
        }
        print2D(root.getRight(), level+10);
        String outputLine = String.format("%1$" + level +"s", root.getData());
        System.out.println(outputLine);
        print2D(root.getLeft(), level+10);
    }
}
