package org.practice.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

public class MaxSubArr {
    public static void main(String args[]){
        MaxSubArr msa = new MaxSubArr();
        System.out.println(msa.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(msa.maxSubArray(new int[]{5,4,-1,7,8}));

    }
//sum of first 1,2,3...
    public int maxSubArray(int[] nums){

        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum=0;
        int maxsum = 0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            hm.put(i,sum);
            maxsum = Math.max(maxsum,sum);
        }
//        if(hm.containsKey(maxsum)){
//            return hm.get(maxsum);
//        }
//        return 0;

        System.out.println(hm);

        return maxsum;
    }




}
