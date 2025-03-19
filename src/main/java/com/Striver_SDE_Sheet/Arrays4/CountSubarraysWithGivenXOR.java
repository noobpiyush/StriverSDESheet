package com.Striver_SDE_Sheet.Arrays4;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenXOR {

    public long subarrayXorBrute(int arr[], int k) {
        // code here

        int n = arr.length;
        long cnt = 0;
        for (int i = 0;i<n;i++){
            long xor = 0;

            for (int j = i;j<n;j++){
                xor = xor ^ arr[j];

                if (xor == k) cnt++;
            }
        }

        return cnt;
    }

    public long subarrayXorOptimal(int arr[], int k) {
        // code here

        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        long cnt = 0;
        int xr = 0;
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            xr = xr ^ arr[i];

            int x = xr ^ k;

            if (map.containsKey(x)) {
                cnt += map.get(x);
            }

            // Insert the prefix xor till index i into the map:
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return cnt;
    }
}
