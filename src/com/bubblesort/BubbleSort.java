package com.bubblesort;

public class BubbleSort {
    public static void main(String[] args) {
        int [] nums ={9,6,4,3,2,1};
        System.out.println("before sorting");
        for(int ele:nums){
            System.out.print( ele+" ");

        }
        System.out.println();
        System.out.print("after sorting");
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }


            }
        }
        System.out.println();

        for(int ele:nums){
            System.out.print(ele+" ");
        }
    }
}
