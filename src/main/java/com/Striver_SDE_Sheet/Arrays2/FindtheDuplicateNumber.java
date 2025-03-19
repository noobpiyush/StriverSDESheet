package com.Striver_SDE_Sheet.Arrays2;

import java.util.Arrays;

public class FindtheDuplicateNumber {

    public int findDuplicateBrute(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        for (int i =0;i<n;i++){
            if (nums[i] == nums[i+1]) return nums[i];
        }

        return -1;
    }

    public int findDuplicateBetter(int[] nums) {

        int n = nums.length;

        int freq[] = new int[n+1];

        for (int i =0;i<n;i++){
            if (freq[nums[i]] == 0){
                freq[nums[i]]++;
            }
            else return nums[i];
        }

        return -1;
    }
}
