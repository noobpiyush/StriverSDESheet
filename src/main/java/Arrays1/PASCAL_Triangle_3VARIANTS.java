package Arrays1;

import java.util.ArrayList;
import java.util.List;

public class PASCAL_Triangle_3VARIANTS {

    //given a row and col no of a pascal triangle print the element at that position
    public static int pascalTriangleV1(int row, int col) {
        return (int) nCr(row, col);
    }

    public static long nCr(int n, int r) {
        long res = 1;

        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    //given a row no of a pascal triangle print the entire row
    public static void pascalTriangleV2Brute(int n) {

        for (int c = 1; c <= n; c++) {
            System.out.println(nCr(n - 1, c - 1));
        }
    }

    //given a row no of a pascal triangle print the entire row
    public static void pascalTriangleV2Optimal(int n) {

        long ans = 1;

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;

            System.out.println(ans);
        }

        System.out.println();
    }

    //    Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
    public static List<List<Integer>> pascalTriangleBrute(int n) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            List<Integer> temp = new ArrayList<>();
            for (int col = 1; col <= row; col++) {
                temp.add((int) nCr(row - 1, col - 1));
            }
            ans.add(temp);
        }
        return ans;
    }

    //Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
    public static List<List<Integer>> pascalTriangleOptima(int n) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            ans.add(pascalTriangleOptimaUtil(row));
        }

        return ans;
    }

    public static List<Integer> pascalTriangleOptimaUtil(int row) {
        List<Integer> ans = new ArrayList<>();

        ans.add(1);

        long res = 1;

        for (int col = 1; col < row; col++) {
            res = res * (row - col);
            res = res / col;
            ans.add((int) res);
        }

        return ans;
    }


    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        System.out.println(pascalTriangleV1(r - 1, c - 1));
        pascalTriangleV2Brute(5);

        System.out.println("The nth row of a pascal triangle");

        pascalTriangleV2Optimal(6);

        List<List<Integer>> ans = new ArrayList<>();

        ans = pascalTriangleBrute(6);

        System.out.println(ans);

        System.out.println(pascalTriangleOptima(6));

    }
}
