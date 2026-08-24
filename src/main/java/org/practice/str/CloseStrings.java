package org.practice.str;

import java.util.Arrays;
//Leet - 1657
public class CloseStrings {
    public static void main(String args[]){

        System.out.println(closeStrings("abc","ba"));
    }

    public static boolean closeStrings(String word1, String word2){
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        for(char ch:word1.toCharArray()){
            w1[ch-'a']++;
        }
        for(char ch:word2.toCharArray()){
            w2[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(w1[i] == 0 && w2[i] != 0 || w1[i] != 0 && w2[i] == 0){
                return false;
            }
        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        return Arrays.equals(w1,w2);

    }
}
