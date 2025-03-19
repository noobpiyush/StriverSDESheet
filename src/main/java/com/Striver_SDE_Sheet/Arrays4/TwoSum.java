package com.Striver_SDE_Sheet.Arrays4;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSumBrute(int n, int[] arr, int target) {
        int ans[] = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }

    public static int[] twoSumBetter(int n, int[] arr, int target) {
        int ans[] = new int[2];

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0;i<n;i++){

            int num = arr[i];

            int moreNeeded = target - num;

            if (map.containsKey(moreNeeded)){
                ans[0] = map.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            map.put(arr[i],i);
        }

        return ans;
    }

    //wont work because we have to return the indices and sorting will change everything
    public static int[] twoSumOptimal(int[] arr, int n, int target) {
        // Sort the array
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        int[] ans = new int[2];
        boolean found = false;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                ans[0] = arr[left];
                ans[1] = arr[right];
                found = true;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // If no solution is found, return an empty array or handle it as needed
        if (!found) {
            return new int[0]; // or throw an exception, or handle it as required
        }

        return ans;
    }
}
