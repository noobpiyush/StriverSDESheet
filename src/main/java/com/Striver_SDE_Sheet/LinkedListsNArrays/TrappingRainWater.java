package com.Striver_SDE_Sheet.LinkedListsNArrays;

public class TrappingRainWater {

    public int trapBrute(int[] height) {
       int n = height.length;

       int prefixMax[] = new int[n];

       int suffixMax[] = new int[n];

       int total = 0;

       prefixMax[0] = height[0];
       for (int i = 1;i<n;i++){
           prefixMax[i]  = Math.max(prefixMax[i-1], height[i]);
       }

       suffixMax[n-1] = height[n-1];

       for (int i = n-2;i>=0;i--){
           suffixMax[i] = Math.max(suffixMax[i + 1],height[i]);
       }

       //calculate total rain water trapped

        for (int i = 0;i<n;i++){

            total += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return total;
    }

    public int trapBetter(int[] height) {
       int n = height.length;
       int prefixMax = Integer.MIN_VALUE;
       int suffixMax[] = new int[n];

       int total = 0;

       suffixMax[n-1] = height[n-1];

       for (int i = n-2;i>=0;i--){
           suffixMax[i] = Math.max(suffixMax[i + 1],height[i]);
       }

       //calculate total rain water trapped
        for (int i = 0;i<n;i++){
            prefixMax = Math.max(prefixMax,height[i]);
            total += Math.min(prefixMax, suffixMax[i]) - height[i];
        }

        return total;
    }

    public int trapOptimal(int[] height) {
       int n = height.length;
       int left = 0;
       int right = n-1;
       int total = 0;

       int maxLeft = 0;
       int maxRight = 0;

       while (left <= right){

           if (height[left] <= height[right]){
               if (maxLeft < height[left]){
                   maxLeft = height[left];
               }
               else {
                   total += maxLeft - height[left];
               }
               left++;
           }else {

               if (maxRight <= height[right]){
                   maxRight = height[right];
               }
               else {
                   total += maxRight - height[right];
               }
               right--;
           }
       }

       return total;
    }
}
