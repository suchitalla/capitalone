package org.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array
 * nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        int i=0,j=0,k=nums.length -1;
        for( i=0;i<nums.length-3;i++) {
            j=j+1;
            k=nums.length -1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(new ArrayList());
                    result.get(result.size() - 1).add(nums[i]);
                    result.get(result.size() - 1).add(nums[j]);
                    result.get(result.size() - 1).add(nums[k]);
                }
                k--;
            }
        }
        return result;
    }

    public static void main(String args[]){
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
