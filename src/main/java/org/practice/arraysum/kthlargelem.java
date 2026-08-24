package org.practice.arraysum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class kthlargelem {

    public static int large(int[] nums,int k){
        List<Integer> numslis = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            numslis.add(nums[i]);
        }

        return quickSelect(numslis,k);


    }
    public static int quickSelect(List<Integer> arr,int k){
        List<Integer> greater = new ArrayList<>();
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        int pivotIndex = new Random().nextInt(arr.size());
        int pivot = arr.get(pivotIndex);
        for(int num:arr){
            if(num > pivot){
                greater.add(num);
            }else if(num < pivot){
                less.add(num);
            }else{
                equal.add(num);
            }
        }
        if(k<=greater.size()){
            return quickSelect(greater,k);
        }else if(k>greater.size() + equal.size()){
            return quickSelect(less,k-greater.size()-equal.size());
        }else{
            return pivot;
        }

    }


    public static void main(String args[]) {
        System.out.println(large(new int[]{3,2,1,5,6,4},2));
    }
}
