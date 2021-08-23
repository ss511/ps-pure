package com.shashank.ps.binaryTrees;

/**
 * Finds the number of turns between two nodes in a binary tree.
 */
public class TurnsInTree {

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


        treeUtils.levelOrder(root);
        System.out.println();
        treeUtils.preOrder(root);
        System.out.println();
        treeUtils.inOrder(root);
        System.out.println();
        treeUtils.postOrder(root);
        System.out.println();

        int data1 = 50;
        int data2 = 5;
        System.out.println("LCA is: " + treeUtils.findLCA(root, 10, 1).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 50;
        data2 = 20;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 50;
        data2 = 25;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 20;
        data2 = 100;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 20;
        data2 = 40;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 50;
        data2 = 100;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 40;
        data2 = 100;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 100;
        data2 = 200;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 20;
        data2 = 200;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));

        data1 = 40;
        data2 = 1011;
        System.out.println(treeUtils.findLCA(root, data1, data2).getData());
        System.out.println("Number of Turns Between " + data1 + " and " + data2 + " = " + findTurns(root, data1, data2));
    }

    private static int findTurns(Tree root, int data1, int data2) {

        BinaryTree treeUtils = new BinaryTree();
        Tree lca = treeUtils.findLCA(root, data1, data2);

        if (lca == null) {
            return -1;
        }

        int count = (lca.getData() == data1 || lca.getData() == data2) ? 0 : 1;

        return count + traverseToNode(lca.getLeft(), data1, data2, false, 0) + traverseToNode(lca.getRight(), data1, data2, true, 0);
    }

    private static int traverseToNode(Tree node, int data1, int data2, boolean isTurn, int turnCount) {

        if (node == null) {
            return 0;
        }
        if (node.getData() == data1 || node.getData() == data2) {
            return turnCount;
        }

        if(!isTurn) {
            return traverseToNode(node.getLeft(), data1, data2, false, turnCount) + traverseToNode(node.getRight(), data1, data2, true, turnCount+1);
        } else {
            return traverseToNode(node.getLeft(), data1, data2, true, turnCount+1) + traverseToNode(node.getRight(), data1, data2, false, turnCount);
        }
    }
}
