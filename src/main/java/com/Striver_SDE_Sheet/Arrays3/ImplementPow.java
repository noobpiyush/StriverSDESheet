package com.Striver_SDE_Sheet.Arrays3;

public class ImplementPow {

    public double myPowBrute(double x, int n) {
        if (n == 0) return 1.0; // Base case: x^0 = 1

        double ans = 1.0;
        int exp = Math.abs(n); // Work with positive exponent

        for (int i = 0; i < exp; i++) {
            ans *= x;
        }

        return (n < 0) ? (1.0 / ans) : ans; // Handle negative exponents
    }

    public double myPow(double x, int n) {
        long nn = n; // Convert n to long to avoid overflow
        double ans = 1.0;

        if (nn < 0) nn = -nn; // Take absolute value safely

        while (nn > 0) {
            // If exponent is odd, multiply result by current x
            if (nn % 2 == 1) {
                ans *= x;
                nn -= 1;
            } else {
                // If exponent is even, square x and halve exponent
                x *= x;
                nn /= 2;
            }
        }

        return (n < 0) ? (1.0 / ans) : ans; // Handle negative exponent case
    }


}
