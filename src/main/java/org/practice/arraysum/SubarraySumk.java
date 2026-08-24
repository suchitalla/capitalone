package org.practice.arraysum;

public class SubarraySumk {

    public int subarraySum(int[] nums, int k) {
     int sum=0;
     for(int i=0;i<nums.length;i++){
         sum=sum+nums[i];
          if(sum==k)
              return i;
          if(sum>k)
              sum=sum-nums[i-1];
     }

        return 0;
    }

    public int subarraySumV2(int[] nums, int k) {
        int minlen = Integer.MAX_VALUE;
        int currsum = 0;
        int left =0;
        for(int right=0;right<nums.length;right++){
            currsum=currsum+nums[right];
            if(currsum > k) {
                minlen = Math.min(minlen,right-left+1);
                currsum = currsum - nums[left];
                left++;
            }
        }
        return minlen == Integer.MAX_VALUE? 0:minlen ;
    }
}
