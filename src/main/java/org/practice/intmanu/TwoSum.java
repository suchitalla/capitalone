package org.practice.intmanu;

import java.util.HashMap;
//Leet - 1
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hasnum = new HashMap<>();
        HashMap<Integer,Integer> tarsum = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hasnum.put(nums[i],i);
            tarsum.putIfAbsent(target - nums[i],i);
        }
        for(int key : tarsum.keySet()){

            if(hasnum.containsKey(key)){
                return new int[]{hasnum.get(key),tarsum.get(key)};
            }

        }
        return new int[]{-1,-1};
    }

    public int[] twoSum(int[] nums, int target, String version) {

        HashMap<Integer,Integer> comps = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            int val = target - nums[i];
            if(comps.containsKey(val)){
                return new int[]{comps.get(val),i};
            }
            comps.put(nums[i],i);
        }

        return null;
    }

}
