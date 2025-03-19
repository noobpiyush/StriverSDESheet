package com.Striver_SDE_Sheet.Arrays3;

import java.util.*;

public class MajorityElementII {

    public List<Integer> findMajorityBrute(int[] nums) {
        // Your code goes here.

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0;i<n;i++){

            if (ans.isEmpty() || ans.get(0) != nums[i]){
                int cnt = 0;

                for (int j =0;j<n;j++){
                    if (nums[i] == nums[j]){
                        cnt++;
                    }
                }

                if (cnt > (n/3)) ans.add(nums[i]);
            }

            if(ans.size() == 2) break;
        }

        Collections.sort(ans);

        return ans;
    }

    public List<Integer> findMajorityBetter(int[] nums) {
        // Your code goes here.
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i<n;i++){
            int value = map.getOrDefault(nums[i],0);
            map.put(nums[i],value+1);

            //checking if v[i] is
            // the majority element:

            if (map.get(nums[i]) > (n/3) && !ans.contains(nums[i])){
                ans.add(nums[i]);
            }

            if (ans.size() == 2) break;
        }

        Collections.sort(ans);

        return ans;
    }


    public List<Integer> findMajorityOptimal(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        // First pass: find potential candidates
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != ele2) {
                cnt1 = 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && nums[i] != ele1) {
                cnt2 = 1;
                ele2 = nums[i];
            } else if (nums[i] == ele1) {
                cnt1++;
            } else if (nums[i] == ele2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Reset counters for the second pass
        cnt1 = 0;
        cnt2 = 0;

        // Second pass: verify the candidates
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1) cnt1++;
            else if (nums[i] == ele2) cnt2++;
        }

        // Check if the candidates are majority elements
        if (cnt1 > (n / 3)) {
            ans.add(ele1);
        }
        if (cnt2 > (n / 3)) {
            ans.add(ele2);
        }

        // Sorting is optional and not required by the problem statement
        Collections.sort(ans);

        return ans;
    }
}
