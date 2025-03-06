package Arrays1;

public class SET_MATRIX_ZERO {

    public static void main(String[] args) {
        int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};
//        setZeroesBrute(matrix);
//        printMatrix(matrix);

        setZeroesBetter(matrix);
        printMatrix(matrix);
    }


    public static void setZeroesOptimal(int mat[][]){
        int n = mat.length;
        int m = mat[0].length;

        int col0 = 1;

        for(int i =0;i<n;i++){
            for (int j = 0;j<m;j++){

                if (mat[i][j] == 0){

                    mat[i][0] = 0;

                    if (j != 0){
                        mat[0][j] = 0;
                    }
                    else col0 = 0;
                }

            }
        }

        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):

        for (int i =1;i<n;i++){
            for (int j =1;j<m;j++){

                if (mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }

        //step 3: Finally mark the 1st col & then 1st row:
        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }

    public static void setZeroesBetter(int mat[][]){
        int n = mat.length;
        int m = mat[0].length;

        int rowMat[] = new int[n];
        int colMat[] = new int[m];

        for (int i =0;i<n;i++){
            for (int j = 0;j<m;j++){
                if (mat[i][j] == 0){
                    rowMat[i]  = 1;
                    colMat[j] = 1;
                }
            }
        }

        for (int  i= 0;i<n;i++){
            for (int j = 0;j<m;j++){
                if (rowMat[i] == 1 || colMat[j] == 1){
                    mat[i][j] = 0;
                }
            }
        }

    }

    public static void printMatrix(int mat[][]){
        for (int i= 0;i<mat.length;i++){
            for (int j = 0;j<mat[0].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroesBrute(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0;i<n;i++){
            for (int j =0;j<m;j++){
                if (matrix[i][j] == 0){
                    markRow(matrix,i);
                    markCol(matrix,j);
                }
            }
        }

        //mark all the -1 with zeros

        for (int i =0;i<n;i++){
            for (int j =0;j<m;j++){
                if (matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void markRow(int mat[][], int rowIndex){

        for (int j =0;j<mat[0].length;j++){
            if (mat[rowIndex][j] != 0){
                mat[rowIndex][j] = -1;
            }
        }
    }

    public static void markCol(int mat[][], int colIndex){

        for (int i = 0;i<mat.length;i++){
            if (mat[i][colIndex] != 0){
                mat[i][colIndex] = -1;
            }
        }
    }
}
