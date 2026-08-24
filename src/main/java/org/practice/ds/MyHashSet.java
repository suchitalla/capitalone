package org.practice.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class MyHashSet<T extends Comparable>{

    ArrayList<T> al = new ArrayList<>();
    public MyHashSet() {
    }

    public void add(T key) {
        Iterator itr = al.iterator();

        boolean exists=false;
        if(al.size() == 0){
            al.add(key);
        }else {
            while (itr.hasNext()) {
                if (itr.next().equals(key)) {
                    exists = true;
                    break;
                }
            }
            if(!exists)
                al.add(key);
        }

    }

    public void remove(T key) {
        Iterator itr = al.iterator();
        if(al.size()>0)
            while(itr.hasNext()){
                if(itr.next().equals(key))
                    itr.remove();
            }
    }

    public boolean contains(T key) {
        Iterator itr = al.iterator();
        while(itr.hasNext()){
            if(itr.next().equals(key))
                return true;
        }
        return false;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Iterator itr = al.iterator();
        while(itr.hasNext()){
            sb.append(itr.next());
            sb.append(",");
        }
        return sb.toString();
    }

    public static void main(String args[]){
        MyHashSet<java.lang.Integer> hs = new MyHashSet<>();
        hs.add(1);
        hs.add(3);
        hs.add(2);
        System.out.println("Contains 2 ? " + hs.contains(2));
        System.out.println( hs);
    }
}