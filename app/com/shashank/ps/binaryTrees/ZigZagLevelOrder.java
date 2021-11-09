package com.shashank.ps.binaryTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Program to perform zigzag level order traversal of a binary tree.
 * Uses two stack, without using any flag to store the order of insertion.
 */
public class ZigZagLevelOrder {

    public static void main(String[] args) {
        BinaryTree treeUtils = new BinaryTree();
        Tree root = treeUtils.insert(20, null);
        treeUtils.insert(10, root);
        treeUtils.insert(5, root);
        treeUtils.insert(1, root);
        treeUtils.insert(25, root);
        treeUtils.insert(100, root);
        treeUtils.insert(40, root);

        System.out.println(Arrays.toString(zigZagLevelOrder(root).toArray()));
    }

    private static List<List<Integer>> zigZagLevelOrder(Tree root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<Tree> st1 = new Stack<>();
        Stack<Tree> st2 = new Stack<>();

        st1.add(root);

        while(!st1.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            while(!st1.isEmpty()) {
                Tree temp = st1.pop();
                inner.add(temp.getData());
                if(temp.getLeft() != null) {
                    st2.push(temp.getLeft());
                }
                if(temp.getRight() != null) {
                    st2.push(temp.getRight());
                }
            }
            if (inner.size() > 0) {
                res.add(inner);
            }
            inner = new ArrayList<>();
            while(!st2.isEmpty()) {
                Tree temp = st2.pop();
                inner.add(temp.getData());
                if(temp.getRight() != null) {
                    st1.push(temp.getRight());
                }
                if(temp.getLeft() != null) {
                    st1.push(temp.getLeft());
                }
            }
            if (inner.size() > 0) {
                res.add(inner);
            }
        }
        return res;
    }
}
