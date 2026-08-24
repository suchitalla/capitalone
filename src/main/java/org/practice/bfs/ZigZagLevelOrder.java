package org.practice.bfs;

import java.util.ArrayList;
import java.util.List;

public class ZigZagLevelOrder {
    public List<List<Integer>> levels = new ArrayList();
    public List<List<Integer>> zigzagLevelOrder(TreeNode ns){

        if(ns==null)
            return levels;

        helper(ns,0);
        return levels;

    }

    public List<List<Integer>> helper(TreeNode ns,int level){
        if(ns!=null){
            if(levels.size() == level)
                levels.add(new ArrayList());

            levels.get(level).add(ns.val);
            level++;
            if(level % 2 == 0) {

                helper(ns.right, level);
                helper(ns.left, level);

            }else{

                helper(ns.left, level);
                helper(ns.right, level);

            }


        }
        return levels;

    }

    public static void main(String args[]){

        ZigZagLevelOrder zz = new ZigZagLevelOrder();
//        System.out.println(zz.traverse(null,0));

        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(
                new TreeNode(null,null,9),
                new TreeNode(new TreeNode(null,null,15),new TreeNode(null,null,7),20),
                3);

//[1,2,3,4,null,null,5]
        TreeNode root2 = new TreeNode(
                new TreeNode(new TreeNode(null,null,4),null,2),
                new TreeNode(null,new TreeNode(null,null,5),3),
                1);

        System.out.println(zz.zigzagLevelOrder(root2));
    }

}
