package org.practice.sort;

import java.util.Arrays;

//Use Pivot,swap and swap and sort
public class QuickSort {

    private static void swap(int[] arr,int first,int sec){
        int temp = arr[first];
        arr[first] = arr[sec];
        arr[sec] = temp;
    }

    private static int pivot(int[] arr,int pivotI,int endI){
        int swapI = pivotI;
        for(int i=pivotI+1;i<=endI;i++)
        {
            if(arr[i] < arr[pivotI]){
                swapI++;
                swap(arr,swapI,i);

            }
        }
        swap(arr,pivotI,swapI);

        return swapI;
    }

    public static void quicksort(int[] arr, int left, int right){
        if(left<right) {
            int pivotIndex = pivot(arr, left, right);
            quicksort(arr, left, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, right);
        }
    }

    public static void main(String args[]){
        int[] arr = {4,6,1,7,3,2,5};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


}
