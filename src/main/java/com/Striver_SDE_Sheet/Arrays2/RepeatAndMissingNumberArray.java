package com.Striver_SDE_Sheet.Arrays2;

public class RepeatAndMissingNumberArray {

    public int[] repeatedNumberBrute(final int[] arr) {

        int n = arr.length;
        int missing = -1, repeating = -1;

        for (int i =1;i<=n;i++){

            int cnt = 0;
            for (int j = 0;j<n;i++){
                if (arr[j] == 1) cnt++;
            }

            if (cnt == 2) repeating = i;
            else if (cnt == 0) missing = i;

            if (missing != -1 && repeating != -1){
                break;
            }
        }

        return new int[]{repeating,missing};
    }

    public static int[] findMissingRepeatingNumbersBetter(int[] a){
        int n = a.length;

        int hash[] = new int[n+1];

        for (int i =0;i<n;i++){
            hash[a[i]]++;
        }

        //Find the repeating and missing number:
        int repeating = -1, missing = -1;

        for (int i = 1;i<=n;i++){

            if (hash[i] == 2) repeating = i;
            else if(hash[i] == 0) missing = i;

            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{repeating,missing};
    }

    public static int[] findMissingRepeatingNumbers(int[] a){
        int n = a.length;

        long S1n = (long)((long) n *(n+1))/2;

        long S2n = (n * (n + 1) * (2L *n + 1))/6;

        long S =0, S2 = 0;

        for (int i = 0;i<n;i++){
            S +=a[i];
            S2 += (long)a[i] * (long)a[i];
        }

        //S-Sn = X-Y:
        long val1 = S - S1n;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2n;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2/val1;


        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:

        long x = (val1 + val2)/2;

        long y = x - val1;

        return  new int[]{(int)x, (int)y};

    }

}
