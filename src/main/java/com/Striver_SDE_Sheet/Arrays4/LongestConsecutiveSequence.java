package com.Striver_SDE_Sheet.Arrays4;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutiveBrute(int[] nums) {
        int n = nums.length;
        if (n ==0) return 0;
        int longest = 1;

        for (int i =0;i<n;i++){
            int x = nums[i];
            int cnt = 1;

            while (ls(nums,x+1,n)){
                x +=1;
                cnt+=1;
            }

            longest = Math.max(longest,cnt);
        }

        return longest;
    }

    public int longestConsecutiveBetter(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
        Arrays.sort(nums);
        int cnt = 0;
        int lastSmallest = Integer.MIN_VALUE;
        int longest = 1;

        for (int i =0;i<n;i++){

            if (nums[i] -1 == lastSmallest){
                //nums[i] is the next element of the
                //current sequence.
                cnt+=1;
                lastSmallest = nums[i];
            }
            else if (nums[i]  != lastSmallest){
                cnt =1;
                lastSmallest = nums[i];
            }

            longest = Math.max(longest,cnt);
        }

        return longest;
    }

    public int longestConsecutiveOptimal(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();

        for (int i =0;i<n;i++){
            set.add(nums[i]);
        }

        for(int it : set){
            // if 'it' is a starting number
            if (!set.contains(it-1)){
                // find consecutive numbers
                int cnt =1;
                int x = it;

                while (set.contains(x+1)){
                    cnt+=1;
                    x = x+1;
                }

                longest = Math.max(longest,cnt);
            }
        }

        return longest;
    }

    public static boolean ls(int arr[], int num, int n){

        for (int i =0;i<n;i++){
            if (arr[i] == num) return true;
        }

        return false;
    }

}
