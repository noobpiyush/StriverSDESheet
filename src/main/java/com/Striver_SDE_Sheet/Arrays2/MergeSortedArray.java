package com.Striver_SDE_Sheet.Arrays2;

import java.util.Arrays;

public class MergeSortedArray {

    public void mergeBrute(int nums1[], int nums2[], int n, int m) {
        int nums3[] = new int[n + m];

        int start1 = 0;
        int start2 = 0;
        int index = 0;

        while (start1 < n && start2 < m) {

            if (nums1[start1] <= nums2[start2]) {
                nums3[index] = nums1[start1];
                index++;
                start1++;
            } else {
                nums3[index] = nums2[start2];
                index++;
                start2++;
            }
        }

        // do for the reamining

        while (start1 < n) {
            nums3[index] = nums1[start1];
            index++;
            start1++;
        }

        while (start2 < m) {
            nums3[index] = nums2[start2];
            index++;
            start2++;
        }
        // Fill back the elements from arr3[]
        // to arr1[] and arr2[]:

        int p = n + m;

        for (int i = 0; i < p; i++) {
            if (i < n) {
                nums1[i] = nums3[i];
            } else {
                nums2[i] = nums3[i];
            }
        }
    }

    public void mergeOptimal(int[] nums1, int n, int[] nums2, int m) {

        int left = n - 1;
        int right = 0;

        while (left >= 0 && right < m) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else break;
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}