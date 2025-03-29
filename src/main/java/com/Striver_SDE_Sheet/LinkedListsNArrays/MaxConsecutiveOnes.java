package com.Striver_SDE_Sheet.LinkedListsNArrays;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int cnt =0;
        int max = 0;

        for (int i =0;i<n;i++){

            if (nums[i] == 1){
                cnt++;
                max = Math.max(cnt,max);
            }
            else{
                cnt = 0;
            }
        }

        return max;
    }
}
