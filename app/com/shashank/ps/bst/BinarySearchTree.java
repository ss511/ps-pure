package com.shashank.ps.bst;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Utility class for creating and manipulating Binary Search Trees.
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        BST tree = binarySearchTree.insert(null, 20);
        binarySearchTree.insert(tree, 30);
        binarySearchTree.insert(tree, 10);
        binarySearchTree.insert(tree, 15);
        binarySearchTree.insert(tree, 25);
        binarySearchTree.insert(tree, 5);
        binarySearchTree.insert(tree, 40);
        binarySearchTree.insert(tree, 35);

        System.out.println("Level Order Traversal");
        binarySearchTree.levelOrder(tree);
        System.out.println("\n\nPre Order Traversal");
        binarySearchTree.preOrder(tree);
        System.out.println("\n\nIn Order Traversal");
        binarySearchTree.inOrder(tree);
        System.out.println("\n\nPost Order Traversal");
        binarySearchTree.postOrder(tree);
        System.out.println("\n\nMax Depth of the BST is: " + binarySearchTree.findMaxDepth(tree) + " [Considering root at level 1]");

        binarySearchTree.deleteNode(tree, 10);

        System.out.println("\n\nLevel Order Traversal");
        binarySearchTree.levelOrder(tree);

    }

    public BST insert(BST root, int data) {
        if (root == null) {
            root = new BST(data, null, null);
        } else {
            if (data < root.getData() && root.getLeft() == null) {
                BST node = new BST(data, null, null);
                root.setLeft(node);
            } else  if (data >= root.getData() && root.getRight() == null) {
                BST node = new BST(data, null, null);
                root.setRight(node);
            } else if (data < root.getData()) {
                insert(root.getLeft(), data);
            } else {
                insert(root.getRight(), data);
            }
        }
        return root;
    }

    // Performs BFS/Level Order on the tree.
    public void levelOrder(BST root) {
        if (root == null) {
            return;
        }

        Queue<BST> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BST temp = queue.poll();
            System.out.print(temp.getData() + " ");
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }

    //Performs Pre Order DFS on the tree.
    public void preOrder(BST root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //Performs In Order DFS on the tree.
    public void inOrder(BST root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    //Performs Post Order DFS on the tree.
    public void postOrder(BST root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    //Finds the maximum depth of the binary tree.
    public int findMaxDepth(BST root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = 1 + findMaxDepth(root.getLeft());
        int rightDepth = 1 + findMaxDepth(root.getRight());

        return Math.max(leftDepth, rightDepth);
    }

    //Delete a Node and rearrange the tree.
    public BST deleteNode(BST root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            BST leaf;
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return root;
            }
            else if (root.getRight() != null) {
                leaf = inOrderSuccessor(root.getRight(), false);
                int temp = root.getData();
                root.setData(leaf.getData());
                leaf.setData(temp);
                root.setRight(deleteNode(root.getRight(), data));
            } else {
                leaf = inOrderSuccessor(root.getLeft(), true);
                int temp = root.getData();
                root.setData(leaf.getData());
                leaf.setData(temp);
                root.setLeft(deleteNode(root.getLeft(), data));
            }
        }
        return root;
    }

    private BST inOrderSuccessor(BST node, boolean isLeftSide) {
        if ((node.getLeft() == null && !isLeftSide) || (node.getRight() == null && isLeftSide)) {
            return node;
        }
        if (isLeftSide) {
            return inOrderSuccessor(node.getRight(), true);
        } else {
            return inOrderSuccessor(node.getLeft(), false);
        }
    }

    //Find if a given node is leaf node.
    public boolean isLeafNode(BST node) {
        if (node == null) {
            return false;
        } else {
            return node.getLeft() == null && node.getRight() == null;
        }
    }
}

/**
 * Data Structure for BST.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class BST {
    private int data;
    private BST left;
    private BST right;
}