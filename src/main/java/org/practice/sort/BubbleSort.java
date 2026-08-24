package org.practice.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void swap(int[] arr,int first,int sec){
        int temp = arr[first];
        arr[first] = arr[sec];
        arr[sec] = temp;
    }

    public static void bubbleSort(int[] arr){

        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }

    }

    public static void main(String args[]){
        int[] arr = new int[]{4,6,1,7,3,2,5};
        System.out.println(Arrays.toString(arr));
        long startTime = System.nanoTime();
        bubbleSort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(Arrays.toString(arr));
        System.out.println("Total Duration = "+duration+" ns");
    }
}
