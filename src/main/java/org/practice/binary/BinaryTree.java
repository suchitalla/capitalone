package org.practice.binary;

import java.util.HashMap;

public class BinaryTree {

    //root is a TreeNode
    TreeNode root;
    HashMap<Integer,Integer> hm = new HashMap<>();

    public BinaryTree() {
    }

    public void insert(TreeNode a){
        if(root == null){
            root = a;
        } else{
            TreeNode temp = root;
            TreeNode parent = null;
            while (temp != null){
                parent = temp;
                if (a.getVal() < temp.getVal()){
                    temp = temp.getLeft();
                } else{
                    temp = temp.getRight();
                }
            }

            if (a.getVal() < parent.getVal()){
                 parent.setLeft(a);
            } else{
                 parent.setRight(a);
            }
        }

    }

    public void inorder(){
        printInOrder(root);
    }

    public void printInOrder(TreeNode a){
        if(a == null)
            return;

        printInOrder(a.getLeft());
        System.out.println(a.getVal());
        printInOrder(a.getRight());
    }

    public HashMap<Integer,Integer> storeInMap(TreeNode a){
        if(a == null)
            return hm;

        storeInMap(a.getLeft());
        if(hm.containsKey(a.getVal())){
            hm.put(a.getVal(),hm.get(a.getVal())+1);
        }else{
            hm.put(a.getVal(),1);
        }
        storeInMap(a.getRight());

        return hm;
    }

    public static void main(String args[]){
        BinaryTree bt = new BinaryTree();
        bt.insert(new TreeNode(10));
        bt.insert(new TreeNode(60));
        bt.insert(new TreeNode(90));
        bt.insert(new TreeNode(20));
        bt.insert(new TreeNode(30));

        bt.inorder();
    }
}
