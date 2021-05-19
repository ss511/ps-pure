package com.shashank.ps.binaryTrees;

/**
 * Finds the difference between sum of nodes at even level and sum of nodes at odd level, where level starts from 0.
 */
public class DifferenceSumLevel {

    public static void main(String[] args) {
        BinaryTree treeUtils = new BinaryTree();
        Tree root = treeUtils.insert(1, null);
        treeUtils.insert(2, root);
        treeUtils.insert(3, root);
        treeUtils.insert(4, root);
        treeUtils.insert(5, root);
        treeUtils.insert(6, root);
        treeUtils.insert(7, root);
        treeUtils.insert(8, root);

        System.out.println("Difference is: " + getDifference(root, 0,0));
    }

    private static int getDifference(Tree root, int diff, int level) {
        if(root == null) {
            return diff;
        }

        if (level % 2 == 0) {
            diff += root.getData();
        } else {
            diff -= root.getData();
        }

        diff = getDifference(root.getLeft(), diff, level+1);
        diff = getDifference(root.getRight(), diff, level+1);

        return diff;
    }
}
