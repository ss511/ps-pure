package com.shashank.ps.binaryTrees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write program to add nodes at a level of a binary tree to linked list. Uses constant time to solve the problem.
 * This program will use a modified tree structure to add one more attribute called next in addition to left and right.
 */
public class LevelNodeList {

    public static void main(String[] args) {
        EnhancedTree root = insert(1, null);
        insert(2, root);
        insert(3, root);
        insert(4, root);
        insert(5, root);
        insert(6, root);
        insert(7, root);
        insert(8, root);
        insert(9, root);

        System.out.println("Original Tree");
        preOrder(root);

        System.out.println();
        System.out.println("After adding next node");
        attachNextLink(root);
        preOrder(root);

    }

    private static void attachNextLink(EnhancedTree root) {
        if (root == null) {
            return;
        }
        Queue<EnhancedTree> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            EnhancedTree node = queue.poll();
            if (node != null) {
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
                if (queue.peek() == null) {
                    node.setNext(null);
                    queue.poll();
                    queue.add(null);
                } else {
                    node.setNext(queue.peek());
                }
            }
        }
    }


    private static void preOrder(EnhancedTree root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + "  ");
        if (root.getNext() != null) {
            System.out.print(root.getNext().getData() + "  ");
        }
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    private static EnhancedTree insert(int data, EnhancedTree tree) {

        if(tree == null) {
            tree = new EnhancedTree(data, null, null, null);
        } else {
            Queue<EnhancedTree> queue = new LinkedList<>();
            queue.add(tree);

            while(!queue.isEmpty()) {
                EnhancedTree temp = queue.poll();
                EnhancedTree newNode = new EnhancedTree(data, null, null, null);
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
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class EnhancedTree {
    private int data;
    private EnhancedTree left;
    private EnhancedTree right;
    private EnhancedTree next;
}
