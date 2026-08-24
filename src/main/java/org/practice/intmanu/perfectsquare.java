package org.practice.intmanu;

import java.util.Arrays;
//Leet - 279
public class perfectsquare {

    static int[] memo;
    public static void main(String[] args) {
        init(12);
        System.out.println(leastnoofPerfectSquares(12));
    }
    static void init(int n){
         memo = new int[n+1];
         Arrays.fill(memo,-1);
    }

    public static int leastnoofPerfectSquares(int n) {

        if( n == 0)
            return 0;
        if(memo[n]!=-1)
            return memo[n];

        int min= Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
           int curr = 1+leastnoofPerfectSquares(n-i*i);
           min = Math.min(min,curr);
        }
        return memo[n] = min;


    }
}
