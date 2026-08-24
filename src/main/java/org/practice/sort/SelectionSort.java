package org.practice.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void swap(int[] arr,int first,int sec){
        int temp = arr[first];
        arr[first] = arr[sec];
        arr[sec] = temp;
    }
    public static void selectionsort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    swap(arr,min,j);
                }
            }
        }

    }

    public static void main(String args[]){
        int[] arr = new int[]{4,6,1,7,3,2,5};
        System.out.println(Arrays.toString(arr));
        long startTime = System.nanoTime();
        selectionsort(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(Arrays.toString(arr));
        System.out.println("Total Duration = "+duration+" ns");
    }

}
