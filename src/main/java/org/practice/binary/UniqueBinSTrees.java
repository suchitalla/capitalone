package org.practice.binary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UniqueBinSTrees {
    ArrayList<BinaryTree> alt = new ArrayList<>();
    HashMap<Integer,Integer> hm = new HashMap<>();

    UniqueBinSTrees(){
        BinaryTree bt1 = new BinaryTree();
        bt1.insert(new TreeNode(10));
        bt1.insert(new TreeNode(20));
        bt1.insert(new TreeNode(90));

        BinaryTree bt2 = new BinaryTree();
        bt2.insert(new TreeNode(1));
        bt2.insert(new TreeNode(20));
        bt2.insert(new TreeNode(30));

        BinaryTree bt3 = new BinaryTree();
        bt3.insert(new TreeNode(5));
        bt3.insert(new TreeNode(20));
        bt3.insert(new TreeNode(40));

        alt.add(bt1);
        alt.add(bt2);
        alt.add(bt3);
    }

    public void findUnique(int n){
        hm.clear();
        for(int i=0;i<alt.size();i++){
            BinaryTree bta = alt.get(i);
            HashMap hm1 = bta.storeInMap(bta.root);
            hm1.forEach((k,v)->hm.merge((Integer) k, (Integer) v,(oldV, newV)-> oldV+newV));
        }

        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            if(entry.getValue() == n){
                System.out.println(entry.getKey());
            }
        }

    }

public static void main(String args[]){
        UniqueBinSTrees ubt = new UniqueBinSTrees();
        ubt.findUnique(3);

}

}
