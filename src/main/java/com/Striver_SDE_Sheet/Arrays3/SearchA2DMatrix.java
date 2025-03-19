package com.Striver_SDE_Sheet.Arrays3;

public class SearchA2DMatrix {

    public boolean searchMatrixBrute(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0;i<n;i++){
            for (int j =0;j<m;j++){

                if (matrix[i][j] == target) return true;
            }
        }

        return false;
    }

    public boolean binarySearch(int arr[],int target){
        int n = arr.length;

        int low = 0, high = n-1;

        while (low <= high){
            int mid = (low + high)/2;

            if (arr[mid] == target){
                return true;
            }
            else if (arr[mid] > target){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrixBetter(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        for (int i =0;i<n;i++){
            if (matrix[i][0] <= target && target <= matrix[i][m-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = n*m - 1;

        while (low <= high){
            int mid = (low + high)/2;

            int row = mid/m;
            int col = mid%m;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] >= target) high = mid -1;
            else low = mid + 1;
        }

        return false;
    }
}
