package com.selectionsort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int [] arr={9,7,5,4,3,2,0};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void selectionSort(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int last=arr.length-i-1;
            // find the maximum element and swap it with last
            // first write a function to find maximum element
            int maxElement=getMax(arr,0,last);
            // then write a function to swap it
                swapIt(arr,maxElement,last);
        }
    }
    private static int getMax(int[] arr, int start, int end) {
        int max = start;
        for (int i = 0; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
    private static void swapIt(int [] arr,int first , int second) {

        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
