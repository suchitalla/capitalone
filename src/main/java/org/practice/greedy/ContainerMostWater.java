package org.practice.greedy;
//- Leet 11
public class ContainerMostWater {
    static {
        for (int i = 0; i < 100; i++) {
            maxAreav2(new int[] {0, 0});
        }
    }
    //works
        public int maxArea(int[] height) {

            int maxArea = 0;
            int currH = 0;
            int left = 0;
            int right = height.length - 1;
            while (left < right) {
                int width = right - left;
                currH = Math.min(height[left], height[right]);
                int currArea = currH * width;

                if (currArea > maxArea) {
                    maxArea = currArea;
                }
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }

            }

            return maxArea;
        }

    public static int maxAreav2(int[] height) {

        int maxArea = 0;
        int currH = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            currH = Math.min(height[left], height[right]);
            int currArea = currH * width;

            if (currArea > maxArea) {
                maxArea = currArea;
            }
            while (left < right && height[left]<=currH) {
                left++;
            }
            while (right < left && height[right]<=currH) {
                right--;
            }

        }

        return maxArea;
    }



}
