package org.practice.ds;

import java.util.LinkedList;

public class MyHashSetL<T extends Comparable> {
    private static final int BASE = 769;
    LinkedList<Integer>[] ll ;

    MyHashSetL(){
        ll = new LinkedList[BASE];
        for(int i=0;i<BASE;i++){
            ll[i] = new LinkedList<>();
        }
    }

    public void add(int key){
        int hash = key%BASE;
        if(!ll[hash].contains(key))
            ll[hash].addFirst(key);


    }

    public boolean contains(int key){
        int hash = key%BASE;
        if(ll[hash].contains(key))
            return true;

        return false;

    }

    public void remove(int key){
        int hash = key%BASE;
        int i=0;
        while(ll[hash].contains(key)) {

            if(ll[hash].get(i).equals(key))
                ll[hash].remove();
            i++;

        }
    }

    public String toString(){
            StringBuilder sb = new StringBuilder();
        for(int i=0;i<BASE;i++){
            sb.append(ll[i]).append(",");
        }
        return sb.toString();
    }
    public static void main(String args[]){
        MyHashSetL<Integer> mhs = new MyHashSetL<>();
        mhs.add(1);
        mhs.add(5);
        mhs.add(3);
        mhs.add(9);
        System.out.println(mhs);
//        mhs.remove(3);
//        System.out.println(mhs);
    }

}
