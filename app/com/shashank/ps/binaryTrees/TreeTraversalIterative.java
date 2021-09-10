package com.shashank.ps.binaryTrees;

import java.util.Stack;

public class TreeTraversalIterative {

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

        System.out.println("********************Pre Order********************");
        preOrder(root);
        System.out.println("\n********************In Order*********************");
        inOrder(root);
        System.out.println("\n********************Post Order*******************");
        postOrder(root);

    }

    private static void preOrder(Tree root) {
        if (root == null) {
            return;
        }
        Stack<Tree> treeStack = new Stack<>();
        treeStack.push(root);

        while(!treeStack.isEmpty()) {
            Tree node = treeStack.pop();
            System.out.print(node.getData() + " ");
            if (node.getRight() != null) {
                treeStack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                treeStack.push(node.getLeft());
            }
        }
    }

    private static void inOrder(Tree root) {
        if (root == null) {
            return;
        }
        Stack<Tree> treeStack = new Stack<>();

        Tree node = root;
        while(node != null || !treeStack.isEmpty()) {
            while (node != null) {
                treeStack.push(node);
                node = node.getLeft();
            }
            node = treeStack.pop();
            System.out.print(node.getData() + " ");
            node = node.getRight();
        }
    }

    private static void postOrder(Tree root) {
        if (root == null) {
            return;
        }

        Stack<Tree> primary = new Stack<>();
        Stack<Tree> aux = new Stack<>();

        primary.push(root);

        while(!primary.isEmpty()) {
            Tree curr = primary.pop();
            aux.push(curr);
            if (curr.getLeft() != null) {
                primary.push(curr.getLeft());
            }
            if (curr.getRight() != null) {
                primary.push(curr.getRight());
            }
        }

        while(!aux.isEmpty()) {
            System.out.print(aux.pop().getData() + " ");
        }
    }
}
