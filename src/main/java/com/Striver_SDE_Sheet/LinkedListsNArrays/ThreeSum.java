package com.Striver_SDE_Sheet.LinkedListsNArrays;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i =0;i<n;i++){
            for (int j = i+1;j<n;j++){
                for (int k = j + 1;k<n;k++){

                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp  = Arrays.asList(nums[i], nums[j], nums[k]);
                        temp.sort(null);
                        set.add(temp);
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }

    public List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for (int i =0;i<n;i++){
            Set<Integer> s1 = new HashSet<>();
            for (int j = i+1;j<n;j++){
                int third = -(nums[i] + nums[j]);
                if (s1.contains(third)){
                    List<Integer> l1 = Arrays.asList(nums[i],nums[j], third);
                    l1.sort(null);
                    set.add(l1);
                }
                s1.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);

        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0;i<n;i++){

            if (i != 0 && nums[i-1] == nums[i]) continue;

            int j = i+1;
            int k = n-1;

            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0){
                    j++;
                } else if (sum > 0) {
                    k--;
                }
                else {
                    List<Integer> l1 = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(l1);

                    j++;
                    k--;

                    //skip  the duplicates
                    while (j < k && nums[j] == nums[j-1]) j++;
                    while (j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }

        return ans;
    }


}
