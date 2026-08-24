package org.practice.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArray {

        public int maxSubArray(int[] nums) {
            int left =0;
            int right = nums.length - 1;
            int totalSum = 0;
            int maxSum = 0;
            int interSum = 0;
            HashMap<String,Integer> maxSums = new HashMap<>();

            while(left<right){
                totalSum=0;
                StringBuilder key=new StringBuilder();
                for(int i=left;i<right;i++){
                    totalSum = totalSum + nums[i];
                    key.append(i);
                }
                maxSums.put(key.toString(),totalSum);
                left++;
            }
            left=0;
            totalSum=0;
            while(left<right){
                totalSum=0;
                StringBuilder key=new StringBuilder();
                for(int i=right-1;i>=0;i--){
                    totalSum = totalSum + nums[i];
                    key.append(i);
                }
                maxSums.put(key.toString(),totalSum);
                right--;
            }
            left=0;
            right = nums.length - 1;
            totalSum=0;
            while(left<right){
                totalSum=0;
                StringBuilder key=new StringBuilder();
                for( left=right-1;left>=0;left--){
                    totalSum = totalSum + nums[left];
                    key.append(left);
                }
                maxSums.put(key.toString(),totalSum);
                left++;
                right--;
            }

            int max=0;
            String maxString = null;

            for (Map.Entry<String, Integer> entry : maxSums.entrySet()) {

                if (entry.getValue() > max){
                    max = entry.getValue();
                    maxString = entry.getKey();
                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                }
            }

            return max;
        }

        public static void main(String args[]){
            MaximumSubArray msa = new MaximumSubArray();
            msa.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

        }

}
