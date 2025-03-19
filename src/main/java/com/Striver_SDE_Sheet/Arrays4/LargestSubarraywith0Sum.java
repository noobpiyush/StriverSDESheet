package com.Striver_SDE_Sheet.Arrays4;

import java.util.HashMap;
import java.util.HashSet;

public class LargestSubarraywith0Sum {
    int maxLenBrute(int arr[]) {
        // code here
        int n = arr.length;

        int longest =0;

        for (int i =0;i<n;i++){
            int sum = 0;
            for (int j = i;j<n;j++){
                sum += arr[j];

                if (sum == 0){
                    longest =Math.max(longest,j-i+1);
                }
            }
        }

        return longest;
    }

    int maxLenOptimal(int arr[]) {
        // code here
        int n = arr.length;

        int longest =0;
        int sum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i =0;i<n;i++){

            sum +=arr[i];

            if (sum == 0){
                longest = i+1;
            }
            else {
                if (map.containsKey(sum)){

                    longest = Math.max(longest,i - map.get(sum));
                }
                else {
                    map.put(sum,i);
                }
            }
        }

        return longest;
    }



    public static void main(String[] args) {
        int a[] = {9, -3, 3, -1, 6, -5};

       LargestSubarraywith0Sum l0 = new LargestSubarraywith0Sum();
        System.out.println("hiii there");
        System.out.println(l0.maxLenBrute(a));
    }
}
