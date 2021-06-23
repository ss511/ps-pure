package com.shashank.ps.binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Finds the average value of each level.
 * Time complexity is O(n) where n is total number of nodes in tree.
 * Time complexity is O(l) where l is max number of nodes at one level.
 */
public class BTLevelAverage {
    public static void main(String[] args) {
        BinaryTree treeUtils = new BinaryTree();
        Tree root = treeUtils.insert(20, null);
        treeUtils.insert(10, root);
        treeUtils.insert(5, root);
        treeUtils.insert(4, root);
        treeUtils.insert(12, root);
        treeUtils.insert(16, root);
        treeUtils.insert(20, root);
        treeUtils.insert(30, root);

        List<Double> average = getLevelAverage(root);

        for (Double val: average) {
            System.out.print(val + "\t");
        }
    }

    private static List<Double> getLevelAverage(Tree root) {
        List<Double> average = new ArrayList<>();

        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sum = 0;
            int count = 0;
            Queue<Tree> temp = new LinkedList<>();
            while(!queue.isEmpty()) {
                Tree node = queue.poll();
                sum+=node.getData();
                count++;
                if (node.getLeft()!=null) {
                    temp.add(node.getLeft());
                }if (node.getRight()!=null) {
                    temp.add(node.getRight());
                }
            }
            queue = temp;
            average.add((sum*1.0)/count);
        }
        return average;
    }
}
