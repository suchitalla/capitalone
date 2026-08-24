package org.practice.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String args[]){
        int[] arr = {4,6,1,7,3,2,5};
        System.out.println(Arrays.toString(mergesort(arr)));
    }

    public static int[] mergesort(int[] arr){

        if(arr.length == 1)
            return arr;
        int mid = arr.length/2;
        int[] left = mergesort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergesort(Arrays.copyOfRange(arr,mid,arr.length));
            return merge(left,right);

    }

    public static int[] merge(int[] arr1,int[] arr2){
        int[] result = new int[arr1.length+arr2.length];
        int comb =0;
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                result[comb] = arr1[i];
                i++;
                comb++;
            } else {
                result[comb] = arr2[j];
                j++;
                comb++;
            }

        }
        while(i<arr1.length){
            result[comb] = arr1[i];
            i++;
            comb++;
        }
        while(j<arr2.length){
            result[comb] = arr2[j];
            j++;
            comb++;
        }

        return result;

    }
}
