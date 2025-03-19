package com.Striver_SDE_Sheet.Arrays1;

public class SortColors {

    public void sortColorsBetter(int[] nums) {
        int zeroesCnt = 0, onesCnt = 0, twosCnt = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){

            if (nums[i] == 0){
                zeroesCnt++;
            } else if (nums[i] == 1) {
                onesCnt++;
            } else {
              twosCnt++;
            }
        }

       for (int i = 0;i<zeroesCnt;i++){
           nums[i] = 0;
       }

       for (int i = zeroesCnt;i<onesCnt +  zeroesCnt;i++){
           nums[i] = 1;
       }

       for (int i = zeroesCnt + onesCnt;i<n;i++){
           nums[i] = 2;
       }


    }
    public void sortColorsOptimal(int[] nums) {
       int n = nums.length;;
        int low = 0, mid = 0, high = n-1;

        while (mid <= high){

            if (nums[mid] == 0 ){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if (nums[mid] == 1){
                mid++;

            }else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }

        }

    }
}
