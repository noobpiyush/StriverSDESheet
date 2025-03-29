package com.Striver_SDE_Sheet.LinkedListsNArrays;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicatesBrute(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
        int n = nums.length;
        for (int i =0;i<n;i++){
            set.add(nums[i]);
        }

        int k = set.size();
        int j = 0;
        for (int x : set){
            nums[j] = x;
            j++;
        }

        return k;
    }
    public int removeDuplicatesOptimal(int[] nums) {
       int i = 0;
       int n = nums.length;
       for (int j = 1;j<n;j++){

           if (nums[i] != nums[j]){
               i++;
               nums[i] = nums[j];
           }
       }

       return i+1;
    }
}
