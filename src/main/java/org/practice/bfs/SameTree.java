package org.practice.bfs;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree st = new SameTree();
        TreeNode tree1 = new TreeNode(new TreeNode(null, null, 2), new TreeNode(null, null, 3), 1);
        TreeNode tree2 = new TreeNode(new TreeNode(null, null, 2), new TreeNode(null, null, 3), 1);
        System.out.println(st.isSameTree(tree1, tree2));
    }

}
