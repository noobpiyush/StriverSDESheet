package com.Striver_SDE_Sheet.Arrays1;

public class BestTimetoBuyandSellStock {

    public int maxProfitBrute(int[] arr) {
        int n = arr.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    maxProfit = Math.max(maxProfit, arr[j] - arr[i]);
                }
            }
        }

        return maxProfit;
    }


    public int maxProfit(int arr[]) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int n = arr.length;

        for (int i = 0;i<n;i++){

            minPrice = Math.min(minPrice,arr[i]);
            maxProfit = Math.max(maxProfit,arr[i] - minPrice);
        }

        return maxProfit;
    }
}
