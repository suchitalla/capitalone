package org.practice.arraysum;
//Leet - 303
public class RangeSumQuery {
    int[] nums;
    public RangeSumQuery(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum=0;
        for(int i=left; left<=right;left++){
            sum=sum+nums[left];
        }
        return sum;

    }
}
