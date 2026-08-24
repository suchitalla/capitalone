package org.practice.dynamicprogramming;
//leet - 70
//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class ClimbingStairs {

    public static int climb(int n){
        //TotalWays = W1*(n-1)+W2*(n-2)

        if(n<=2)
            return n;
// if n=2 , prevstep2 = 1 ways and prevstep1 = 2 ways currstep is total of step 1 and step2
        int currstep =0 ;
        int prevstep1=2;
        int prevstep2=1;

        for(int i=3;i<=n;i++){
            currstep = prevstep1 + prevstep2;
            prevstep2 = prevstep1;
            prevstep1 = currstep;
        }
            return currstep;
    }

    public static void main(String[] args) {
        System.out.println(ClimbingStairs.climb(5));

    }

}
