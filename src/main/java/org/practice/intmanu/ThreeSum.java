package org.practice.intmanu;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(ThreeSum.closestTriplet(new int[]{-1,2,1,-4},1));
    }

    public static int closestTriplet(int[] nums, int target) {

        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[2];

        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right =nums.length-1;
            while(left<right){
                int sum =nums[i]+nums[left]+nums[right];

                if(Math.abs(sum-target)<Math.abs(closestSum-target)){
                    closestSum = sum;
                }

                 else if(sum < target){
                    left++;
                } else if(sum > target) {
                    right--;
                } else{
                     return closestSum;
                }

            }
        }


        return closestSum;
    }
}
