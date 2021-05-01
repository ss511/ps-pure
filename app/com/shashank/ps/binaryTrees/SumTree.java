package com.shashank.ps.binaryTrees;

/**
 * This program finds out if a given tree is a sum tree.
 */
public class SumTree {

    public static void main(String[] args) {
        BinaryTree treeUtils = new BinaryTree();
        Tree root = treeUtils.insert(34, null);
        treeUtils.insert(10, root);
        treeUtils.insert(7, root);
        treeUtils.insert(4, root);
        treeUtils.insert(6, root);
        treeUtils.insert(3, root);
        treeUtils.insert(4, root);

        System.out.println("The given tree is a sum tree: " + isSumTree(root));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Result Using V2, more efficient method.");
        int sum = isSumTreeV2(root, Integer.MIN_VALUE);
        if (sum == Integer.MIN_VALUE) {
            System.out.println("The given tree is not a sum tree");
        } else {
            System.out.println("The given tree is a sum tree");
        }
    }

    //More efficient -- O(n) time complexity
    private static int isSumTreeV2(Tree root, int sum) {
        if (root == null) {
            return 0;
        }
        if (isLeafNode(root)) {
            return root.getData();
        }
        if (root.getData() == (isSumTreeV2(root.getLeft(), sum) + isSumTreeV2(root.getRight(), sum))) {
            return 2*root.getData();
        }
        return Integer.MIN_VALUE;
    }

    private static boolean isLeafNode(Tree node) {
        if (node == null) {
            return false;
        }
        return (node.getLeft() == null && node.getRight() == null);
    }

    private static boolean isSumTree(Tree root) {
        if (root == null ||
                (root.getLeft() == null && root.getRight() == null)) {
            return true;
        }

        if (root.getData() != getSubTreeSum(root.getLeft())+getSubTreeSum(root.getRight())) {
            return false;
        }

        return isSumTree(root.getLeft()) && isSumTree(root.getRight());
    }

    private static int getSubTreeSum(Tree node) {
        if (node == null) {
            return 0;
        }
        return node.getData() + getSubTreeSum(node.getLeft()) + getSubTreeSum(node.getRight());
    }
}
