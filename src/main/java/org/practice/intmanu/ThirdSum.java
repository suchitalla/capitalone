package org.practice.intmanu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdSum {
    public List<List<Integer>> thirdSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = n - 1;

                while (left < right) {
                    // Use long to avoid 32-bit integer overflow
                    long sum = (long) nums[i]  + nums[left] + nums[right];

                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        // Skip duplicates for left and right pointers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThirdSum().thirdSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
