package com.shashank.ps.binaryTrees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Util class for Binary Tree.
 */
public class BinaryTree {

    //Creates binary tree with help of a queue.
    public Tree insert(int data, Tree tree) {

        if(tree == null) {
            tree = new Tree(data, null, null);
        } else {
            Queue<Tree> queue = new LinkedList<>();
            queue.add(tree);

            while(!queue.isEmpty()) {
                Tree temp = queue.poll();
                Tree newNode = new Tree(data, null, null);
                if (temp.getLeft() == null) {
                    temp.setLeft(newNode);
                    break;
                } else {
                    queue.add(temp.getLeft());
                }
                if (temp.getRight() == null) {
                    temp.setRight(newNode);
                    break;
                } else {
                    queue.add(temp.getRight());
                }
            }
        }
        return tree;
    }

    // Performs BFS/Level Order on the tree.
    public void levelOrder(Tree root) {
        if (root == null) {
            return;
        }

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Tree temp = queue.poll();
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
    public void preOrder(Tree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    //Performs In Order DFS on the tree.
    public void inOrder(Tree root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        inOrder(root.getRight());
    }

    //Performs Post Order DFS on the tree.
    public void postOrder(Tree root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + " ");
    }

    //Finds the maximum depth of the binary tree.
    public int findMaxDepth(Tree root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = 1 + findMaxDepth(root.getLeft());
        int rightDepth = 1 + findMaxDepth(root.getRight());

        return Math.max(leftDepth, rightDepth);

    }

    public Tree findLCA(Tree root, int data1, int data2) {
        if (root == null) {
            return null;
        }
        if (root.getData() == data1 || root.getData() == data2) {
            return root;
        }

        Tree leftCommon = findLCA(root.getLeft(), data1, data2);

        Tree rightCommon = findLCA(root.getRight(), data1, data2);

        if(leftCommon != null && rightCommon != null) {
            return root;
        }

        return (leftCommon != null) ? leftCommon : rightCommon;
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Tree {
    private int data;
    private Tree left;
    private Tree right;
}
