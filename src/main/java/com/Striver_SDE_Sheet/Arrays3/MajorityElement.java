package com.Striver_SDE_Sheet.Arrays3;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElementBrute(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
            if (cnt > (n / 2)) return nums[i];
        }
        return -1;
    }
    public int majorityElementBetter(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for (int i =0;i<n;i++){
            int value = map.getOrDefault(nums[i],0);
            map.put(nums[i], value + 1);
        }

        //searching for the majority element:

        for (Map.Entry<Integer,Integer> it : map.entrySet()){
            if (it.getValue() > (n/2)){
                return it.getKey();
            }
        }

        return -1;
    }
    public int majorityElementOptimal(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int ele = 0;
        for (int i =0;i<n;i++){

            if (cnt == 0) {
                ele = nums[i];
                cnt =1;
            }
            else if (ele == nums[i]) cnt++;
            else cnt--;
        }
        cnt = 0;
        for (int i =0;i<n;i++){
            if (nums[i] == ele) cnt++;
        }

        return cnt > (n/2) ? ele : -1;
    }
}
