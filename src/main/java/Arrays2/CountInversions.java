package Arrays2;

import java.util.ArrayList;

public class CountInversions {

    static int inversionCount(int arr[]) {
        return mergeSort(0, arr.length - 1, arr);
    }

    public static int mergeSort(int low, int high, int arr[]) {
        int cnt = 0;

        if (low >= high) return cnt; // Corrected base case

        int mid = (low + high) / 2;
        cnt += mergeSort(low, mid, arr);
        cnt += mergeSort(mid + 1, high, arr);
        cnt += merge(arr, low, mid, high); // Corrected merge function call

        return cnt;
    }

    public static int merge(int arr[], int low, int mid, int high) { // Corrected parameter order
        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;
        int cnt = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); // Inversion count
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return cnt;
    }
}
