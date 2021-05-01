package com.shashank.ps.binaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubTree {
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

        Tree subTree = treeUtils.insert(10, null);
        treeUtils.insert(1, subTree);
        treeUtils.insert(25, subTree);
        treeUtils.insert(50, subTree);
        treeUtils.insert(200, subTree);

        System.out.println("Is subTree object a sub tree of root object: "+ isSubTree(root, subTree));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Result Using V2, more efficient method.");
        System.out.println("Is subTree object a sub tree of root object: "+ isSubTreeV2(root, subTree));

    }

    static boolean isSubTree(Tree root, Tree subTree) {
        if (root == null && subTree == null) {
            return true;
        }
        if (root == null || subTree == null) {
            return false;
        }
        if (root.getData() != subTree.getData()) {
            return (isSubTree(root.getLeft(), subTree) || isSubTree(root.getRight(), subTree));
        } else {
            return (isSubTree(root.getLeft(), subTree.getLeft()) && isSubTree(root.getRight(), subTree.getRight()));
        }
    }

    //Uses more efficient technique of inorder and post order traversal to find out.
    static boolean isSubTreeV2(Tree root, Tree subTree) {

        List<Integer> mainTreeList = new ArrayList<>();
        List<Integer> subTreeList = new ArrayList<>();

        getInOrderList(root, mainTreeList);
        getInOrderList(subTree, subTreeList);

        String mainTreeText = mainTreeList.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        String subTreeText = subTreeList.stream().map(Object::toString)
                .collect(Collectors.joining(""));

        if(!mainTreeText.contains(subTreeText)){
            return false;
        }

        mainTreeList = new ArrayList<>();
        subTreeList = new ArrayList<>();

        getPostOrderList(root, mainTreeList);
        getPostOrderList(subTree, subTreeList);

        mainTreeText = mainTreeList.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        subTreeText = subTreeList.stream().map(Object::toString)
                .collect(Collectors.joining(""));

        return mainTreeText.contains(subTreeText);
    }

    static void getInOrderList(Tree node, List<Integer> list) {
        if (node == null) {
            return;
        }
        getInOrderList(node.getLeft(), list);
        list.add(node.getData());
        getInOrderList(node.getRight(), list);
    }

    static void getPostOrderList(Tree node, List<Integer> list) {
        if (node == null) {
            return;
        }
        getPostOrderList(node.getLeft(), list);
        getPostOrderList(node.getRight(), list);
        list.add(node.getData());
    }
}
