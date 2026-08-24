package org.practice.ds;

import java.util.ArrayList;

public class MyHashMap<K,V> {
    Node<K,V>[] hasharray;
    int size;
    private static final int default_capacity = 16;
    private static final double load_factor =0.75;

    public MyHashMap(){
        hasharray = new Node[default_capacity];
        size = 0;
    }

    public static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;

        Node(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    private int getbucketIndex(K key){
        if(key == null) return 0;
        return Math.abs(key.hashCode()) % hasharray.length;
    }

    void put(K key,V value){
        int index = getbucketIndex(key);
        Node<K,V> node = new Node<>(key,value);
        if(hasharray[index] == null){
            hasharray[index] = node;
        }else{
            Node<K,V> curr = hasharray[index];
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = node;
        }
        size++;
    }

    V get(K key){
        int index = getbucketIndex(key);
        Node<K,V> curr = hasharray[index];
        while(curr != null){
            if(curr.key.equals(key)){
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    void remove(K key){
        int index = getbucketIndex(key);
        Node<K,V> curr = hasharray[index];
        Node<K,V> prev = null;
        while(curr != null){
            if(curr.key.equals(key)){
                if(prev == null){
                    hasharray[index] = curr.next;
                }else{
                    prev.next = curr.next;
                }
            }
        }
        size--;
    }

    void resize(){
        Node<K,V>[] oldhasharray = hasharray;
        hasharray =   new Node[oldhasharray.length*2];
        for(Node<K,V> node:oldhasharray){
            while(node != null){
                put(node.key,node.value);
                node = node.next;
            }
        }
    }

    int size(){
        return size;
    }
    boolean isEmpty(){
        return size == 0;
    }


    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Test basic puts
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // Test overriding an existing key
        map.put("Apple", 15);

        // Test retrieval
        System.out.println("Apple: " + map.get("Apple"));   // Output: 15
        System.out.println("Banana: " + map.get("Banana")); // Output: 20

        // Test Null Key support
//        map.put(null, 99);
//        System.out.println("Null Key: " + map.get(null));   // Output: 99

        // Test removal
         map.remove("Banana"); // Output: 20
        System.out.println("Get Banana after removal: " + map.get("Banana")); // Output: null

        System.out.println("Current Map Size: " + map.size()); // Output: 3
    }

}
