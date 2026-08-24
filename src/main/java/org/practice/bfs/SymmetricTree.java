package org.practice.bfs;

public class SymmetricTree {

    boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        return left.val == right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

    boolean isSymmetric(TreeNode root){
        if(root == null)
            return true;
        return isSymmetric(root.left,root.right);
    }

    public static void main(String args[]){
        SymmetricTree  st =   new SymmetricTree();
        System.out.println(st.isSymmetric(null));

        TreeNode root = new TreeNode(new TreeNode(null,null,2),new TreeNode(null,null,1),2);
        System.out.println(st.isSymmetric(root));

    }

}
