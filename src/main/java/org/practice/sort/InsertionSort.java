package org.practice.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionsort(int[] arr){

        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp) {
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
            }
        }

    public static void main(String args[]){
        int[] arr = new int[]{4,6,1,7,3,2,5};
        System.out.println(Arrays.toString(arr));
        long startTime = System.nanoTime();
        insertionsort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(Arrays.toString(arr));
        System.out.println("Total Duration = "+duration+" ns");
    }

}
