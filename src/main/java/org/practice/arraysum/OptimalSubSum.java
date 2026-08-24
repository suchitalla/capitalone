package org.practice.arraysum;

import java.util.*;

public class OptimalSubSum {

    public int solution(int[] numbers) {
        int maxSoFar = numbers[0];
        int currentMax = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            // Dynamic Programming: Choose to start new or continue current
            currentMax = Math.max(numbers[i], currentMax + numbers[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    public int[] barray(int[] numbers) {
        int[] b = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            b[i] = numbers[(i-1 >= -1) ?0:i-1]+numbers[i]+numbers[(i+1 >=numbers.length)  ?0:i+1];
        }
        return b;
    }

    public int[] sumTarget(int[] numbers,int target) {
        //complement,indice
        HashMap<Integer,Integer> memo = new HashMap<>();
//        int[] summer = new int[2];
        for(int i=0;i<numbers.length;i++){
            int complement = target - numbers[i];
            if(!memo.containsKey(complement)){
                memo.put(numbers[i],i);
            } else{
                return new int[]{memo.get(complement),i};
            }
        }
                return new int[]{};

    }


    public String longestPrefix(String[] str){

        if(str.length == 0 || str == null){
            return "";
        }

        for(int i=0;i<str[0].length();i++){
            char ch = str[0].charAt(i);
            for(int j=1;j<str.length;j++){
                if(i == str[j].length() || str[j].charAt(i) != ch){
                    return str[0].substring(0,i);
                }
            }

        }

        return str[0];

    }

    public String longestPrefixV2(String[] str){

        if(str.length == 0 || str == null){
            return "";
        }

        for(int i=0;i<str[0].length();i++){
            char ch = str[0].charAt(i);
            for(int j=1;j<str.length;j++){
                if(i == str[j].length() || str[j].charAt(i) != ch){
                    return str[0].substring(0,i);
                }
            }

        }

        return str[0];

    }


        public List<List<Integer>> threeSum(int[] nums) {
            nums = sortArray(nums);
            HashSet<List<Integer>> result = new HashSet();

            for(int i=0;i<nums.length -2 ; i++){
                int j = i+1;
                int k = nums.length -1;
                while(k>j){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(sum == 0){
                        List<Integer> ls = new ArrayList<Integer>();
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        result.add(ls);
                        j++;
                        k--;
                    }else if(sum<0){
                        j++;
                    } else {
                        k--;
                    }
                }

            }
            return new ArrayList(result);

        }

        public int[] sortArray(int nums[]){

        HashMap<Integer,Integer> nummap = new HashMap();
        int min=nums[0], max = nums[0];
        for(int i=0;i<nums.length;i++){

            if(nummap.containsKey(nums[i])){
                nummap.put(nums[i],nummap.get(nums[i])+1);
            }else{
                nummap.put(nums[i],1);
            }
            if(nums[i]>max){
                max = nums[i];
            }

            if(nums[i]<min){
                min = nums[i];
            }

        }
        int index =0;
        for(int i = min; i<=max;i++){
            while(nummap.getOrDefault(i,0)>0){
                nums[index] = i;
                nummap.put(i,nummap.get(i)-1);
                index++;
            }
        }

        return nums;

        }



    public int maxDistance(int[] nums1, int[] nums2) {


        int max=0;
        for (int i=0;i<nums1.length;i++){
            int j = binaryS(nums2,nums1[i]);
            max = Math.max(max,(j - i));

        }

        return max;
    }

    int binaryS(int[] nums2,int pivot){

        int left=0;
        int right = nums2.length - 1;
        while(left<right){
            int mid = left + (right-left+1)/2;
            if( nums2[mid] < pivot)
                right= mid-1;
            else
                left = mid;
        }

        return left;

    }

    public static void main(String args[]){
        OptimalSubSum oss = new OptimalSubSum();
//        int[] chkmax = {1,-1,2,5,-6};
//        int[] chkmax = {2,11,15,7};
        //System.out.println(oss.solution(chkmax));
//        System.out.println(Arrays.toString(oss.barray(chkmax)));

//        System.out.println(Arrays.toString(oss.sumTarget(chkmax,9)));
//        String[] chklong = {"flower","flow","flight","f"};
//        System.out.println(oss.longestPrefix(chklong));
        //-1,0,1,2,-1,-4
//        int[] threesum = {-4,-1,-1,0,1,2};
//        int[] threesum = {-1,0,1,2,-1,-4};
//        System.out.println(oss.threeSum(threesum));
                int[] num1 =  {55,30,5,4,2};
                int[] num2 =  {100,20,10,10,5};
        System.out.println(oss.maxDistance(num1,num2));
    }
}