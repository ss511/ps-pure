package com.shashank.ps.bst;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Print nodes of a Binary Search Tree in Top Level Order and Reversed Bottom Level Order alternately.
 * Problem Description - https://www.geeksforgeeks.org/print-nodes-of-a-binary-search-tree-in-top-level-order-and-reversed-bottom-level-order-alternately/
 * Solution is bit different from geeksforgeeks
 */
public class TopBottomAlternateLevelOrder {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TopBottomAlternateLevelOrder tbalo = new TopBottomAlternateLevelOrder();
        BST tree = binarySearchTree.insert(null, 25);
        binarySearchTree.insert(tree, 20);
        binarySearchTree.insert(tree, 36);
        binarySearchTree.insert(tree, 10);
        binarySearchTree.insert(tree, 22);
        binarySearchTree.insert(tree, 30);
        binarySearchTree.insert(tree, 40);
        binarySearchTree.insert(tree, 5);
        binarySearchTree.insert(tree, 12);
        binarySearchTree.insert(tree, 28);
        binarySearchTree.insert(tree, 38);
        binarySearchTree.insert(tree, 48);
        binarySearchTree.insert(tree, 58);

        tbalo.printBST(tree);
    }

    private void printBST(BST root) {

        if (root == null) {
            System.out.println("Tree is empty.");
        }
        PriorityQueue<Pair> low = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.getLevel() != o2.getLevel()) {
                    return o1.getLevel() - o2.getLevel();
                } else {
                    return o1.getValue() - o2.getValue();
                }
            }
        });
        PriorityQueue<Pair> high = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.getLevel() != o2.getLevel()) {
                    return o2.getLevel() - o1.getLevel();
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        Queue<BST> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;

        while (!queue.isEmpty()) {
            BST node = queue.poll();
            if (node != null) {
                Pair pair = new Pair(node.getData(), level);
                low.add(pair);
                high.add(pair);
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            } else {
                break;
            }
            if (queue.peek() == null) {
                level++;
                queue.add(queue.poll());
            }
        }

        int mid = (int) Math.ceil((double) (level-1) / 2);

        while (!low.isEmpty() && !high.isEmpty()) {
            Pair forward = low.poll();
            Pair reverse = high.poll();

            while(forward.getLevel() <= low.peek().getLevel() && forward.getLevel() <= mid) {
                System.out.print(forward.getValue() + "\t");
                if (forward.getLevel() < low.peek().getLevel()) {
                    break;
                }
                forward = low.poll();
            }
            while(reverse.getLevel() >= high.peek().getLevel() && reverse.getLevel() > mid) {
                System.out.print(reverse.getValue() + "\t");
                if (reverse.getLevel() > high.peek().getLevel()) {
                    break;
                }
                reverse = high.poll();
            }
            if (forward.getLevel() > mid && reverse.getLevel() <= mid) {
                break;
            }
        }

    }
}

@Getter
@Setter
@AllArgsConstructor
class Pair {
    private int value;
    private int level;
}
