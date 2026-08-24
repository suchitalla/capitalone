package org.practice.str;

import java.util.HashSet;
//Leet - 3
public class LengthOfLongSubstring {

    public static void main(String args[]){
        System.out.println(lenlongsubstr("abcdabcdabab"));
    }

    public static int lenlongsubstr(String val){
        int left=0;
        int right=0;
        int maxlen=0;
           HashSet<Character> hm = new HashSet<>();
        for(right=0;right<val.length();right++){
            char  ch = val.charAt(right);
            while(hm.contains(val.charAt(right))){
                hm.remove(val.charAt(left));
                left++;
            }
            hm.add(ch);
            maxlen = Math.max(maxlen,right-left+1);

        }

        return maxlen;
    }

}
