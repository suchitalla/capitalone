package org.practice.ht;

import java.util.*;

public class AnagramList {

    public static void main(String args[]){
        AnagramList anagramList = new AnagramList();
        System.out.println(anagramList.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

            HashMap<String, ArrayList<String>> hm = new HashMap<>();
            for(int i=0;i< strs.length;i++){
                char[] keyarr = strs[i].toCharArray();
                Arrays.sort(keyarr);
                String key =  new String(keyarr);
                if(hm.containsKey(key)){
                    ArrayList<String> x = hm.get(key);
                    x.add(strs[i]);
                    hm.put(key,x);
                }else{
                    ArrayList<String> x = new ArrayList<>();
                    x.add(strs[i]);
                    hm.put(key,x);
                }
            }

            List<List<String>> x = new ArrayList(hm.values());
            return x;

        }



}
