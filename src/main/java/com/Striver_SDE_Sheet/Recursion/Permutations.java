package com.Striver_SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean [] freq = new boolean[nums.length];
        rec(nums,ds,ans,freq);

        return ans;
    }

    public  void optimalRec(int index, int nums[], int n, List<List<Integer>> ans){

        if (index == n){
            List<Integer> ds = new ArrayList<>();

            for (int i = 0;i<n;i++){
                ds.add(nums[i]);
            }

            ans.add(new ArrayList<>(ds));

            return;
        }

        for (int i = index;i<n;i++){
            swap(i,index,nums);
            optimalRec(index + 1, nums, n, ans);
            //backtract
            swap(i,index,nums);
        }

    }

    public void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void rec(int nums[], List<Integer> ds, List<List<Integer>> ans, boolean freq[]){

        if (ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i =0;i<nums.length;i++){
            if (!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                rec(nums, ds, ans, freq);
                ds.removeLast();
                freq[i] = false;
            }
        }
    }
}
