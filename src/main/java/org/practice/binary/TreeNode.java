package org.practice.binary;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }



    public TreeNode(int val) {
        this.val = val;
    }


}
