package com.Striver_SDE_Sheet.Arrays2;

public class RotateImage {

    public void rotateBrute(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int rotated[][] = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                rotated[j][n-i-1] = matrix[i][j];
            }
        }

        for(int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                matrix[i][j] = rotated[i][j];
            }
        }
    }

    public void rotateOptimal(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        //1st transpose the matrix

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0;i<n;i++){
            for (int j = 0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
