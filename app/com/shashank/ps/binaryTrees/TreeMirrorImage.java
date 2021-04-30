package com.shashank.ps.binaryTrees;

/**
 * Program to convert a tree into its mirror image.
 */
public class TreeMirrorImage {

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

        System.out.println("Original Tree");
        treeUtils.levelOrder(root);

        System.out.println();
        root = mirrorImage(root);

        System.out.println("Mirror Image");
        treeUtils.levelOrder(root);

        System.out.println();
        root = mirrorImage(root);

        System.out.println("Reverting to original");
        treeUtils.levelOrder(root);
    }

    static Tree mirrorImage(Tree root) {
        if(root == null) {
            return null;
        }
        mirrorImage(root.getLeft());
        mirrorImage(root.getRight());
        Tree temp = root.getRight();
        root.setRight(root.getLeft());
        root.setLeft(temp);
        return root;
    }
}
