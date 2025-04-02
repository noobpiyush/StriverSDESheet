package com.Striver_SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDupBrute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        int n = nums.length;
        int index = 0;

        //sort the arr to avoid duplicates
        Arrays.sort(nums);
        utilBrute(nums,index,n,ans,subset);

        return ans;
    }

    public void utilBrute(int nums[], int index, int n, List<List<Integer>> ans, List<Integer> subset) {

        if (index == n) {

            if (!ans.contains(subset)) {
                ans.add(new ArrayList<>(subset));
            }

            return;
        }

        //take
        subset.add(nums[index]);
        utilBrute(nums, index + 1, n, ans, subset);

        //not take + backtracking;
        subset.removeLast();
        utilBrute(nums, index + 1, n, ans, subset);
    }

    public List<List<Integer>> subsetsWithDupOptimal(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        int n = nums.length;
        int index = 0;

        //sort the arr to avoid duplicates
        Arrays.sort(nums);
        optimalUtil(nums,index,n,ans,subset);

        return ans;
    }

    public void optimalUtil(int nums[], int index, int n, List<List<Integer>> ans, List<Integer> subset){
        ans.add(new ArrayList<>(subset)); //deep copy
        for (int i = index;i<n;i++){

            if (i != index &&  nums[i-1] == nums[i]) continue;

            subset.add(nums[i]);

            optimalUtil(nums,i+1,n,ans,subset);

            subset.removeLast();
        }
    }

   
}