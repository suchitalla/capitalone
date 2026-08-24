package org.practice.dynamicprogramming;
//Leet - 1750
public class MinLenStrSimEndsDel {

    public static void main(String[] args) {
        System.out.println(minLength("cabaabac"));
    }

    public static int minLength(String s1) {
    char[] s1arr = s1.toCharArray();

     int i=0,j=s1arr.length-1;
     for(;i<s1arr.length && i!=j ;i++,j--){
          if(s1arr[i]!=s1arr[j])
              break;
         if(j<i)
             break;
         if(i==j)
             return 0;

      }
      return s1arr.length;
    }
}
