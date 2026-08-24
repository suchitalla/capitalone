package org.practice.bfs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode ns){
        List<List<Integer>> levels = new ArrayList();

        if(ns == null)
            return levels;
        //traverse the node add vals at different levels
        int level =0;
        traverse(ns,levels,level);
        return levels;
    }

    public void traverse(TreeNode ns, List<List<Integer>> levels,int level){
        if(ns != null) {
            if (levels.size() == level )
                levels.add(new ArrayList());

            levels.get(level).add(ns.val);
            if(ns.left != null)
            traverse(ns.left, levels, level+1);
            if(ns.right != null)
            traverse(ns.right, levels, level+1);
        }

    }

    public static void main(String args[]){

        BinaryTreeLevelOrder bt = new BinaryTreeLevelOrder();
        System.out.println(bt.levelOrder(null));

        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(
                new TreeNode(null,null,9),
                new TreeNode(new TreeNode(null,null,15),new TreeNode(null,null,7),20),
                3);

        System.out.println(bt.levelOrder(root));
    }

}
