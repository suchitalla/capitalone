package org.practice.arraysum;

import java.util.HashMap;
//Leet - 525
public class ContigousArr {
    HashMap<Integer,Integer> sums = new HashMap<>();

    public int findLength(int[] nums) {
     int maxlen = 0;
     int runningsum = 0;
     //sum,index
     sums.put(0,-1);

     for(int i=0;i<nums.length;i++){
         if(nums[i] == 0){
             runningsum = runningsum -1;
         } else{
             runningsum = runningsum +1;
         }

         if(sums.containsKey(runningsum)){
             int previndex = sums.get(runningsum);
             maxlen = Math.max(maxlen,i-previndex);
         } else{
             sums.put(runningsum,i);
         }

     }
        return maxlen;
    }
}
