package org.practice.ht;

import java.util.HashMap;

public class LongestString {

        public int lengthOfLongestSubstring(String s) {

            HashMap<Character,Integer> hm = new HashMap<>();
            int left=0;
            int right=0;
            int maxlen =0;

            for(right=0;right<s.length();right++){

                if(hm.containsKey(s.charAt(right))){

                    left = Math.max(left,hm.get(s.charAt(right))+1);
                }
                hm.put(s.charAt(right),right);
                maxlen = Math.max(maxlen,right-left+1);
            }

            return maxlen;

        }

    public String palin(String s) {

        HashMap<Character,Integer> hm = new HashMap<>();
        int left=0;
        int right=0;
        int maxlen =0;

        for(right=0;right<s.length();right++){

            if(hm.containsKey(s.charAt(right))){

                left = Math.max(left,hm.get(s.charAt(right))+1);
            }
            hm.put(s.charAt(right),right);
            maxlen = Math.max(maxlen,right-left+1);
        }
        String sub = s.substring(left,left+maxlen);
        StringBuffer sb = new StringBuffer(sub);
        if(sb.reverse().equals(s)){
            return sb.toString();
        }else{
            return null;
        }


    }

    public static void main(String args[]){
        LongestString ls = new LongestString();
//        ls.lengthOfLongestSubstring("awewek");
        System.out.println(ls.palin("cbbd"));
    }

}