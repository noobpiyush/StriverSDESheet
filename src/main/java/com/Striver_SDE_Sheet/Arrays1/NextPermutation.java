package com.Striver_SDE_Sheet.Arrays1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static List< Integer > nextGreaterPermutation(List< Integer > a){
        int n = a.size();
        int index = -1;
        //find from back of the arr[] arr[i]<arr[i+1]

        for (int i = n-2;i>=0;i--){
            if (a.get(i) < a.get(i+1)){
                index = i;
                break;
            }
        }

        //if np index is found that means its the last permutation so rev and return

        if (index == -1) {
            Collections.reverse(a);
            return a;
        }

        //if index found  Find the next greater element
        //        //         and swap it with arr[ind]:

        for (int i = n-1;i>index;i--){
            if (a.get(index) < a.get(i)){
                int temp = a.get(i);
                a.set(i,a.get(index));
                a.set(index,temp);
                break;
            }
        }

        //reverse the right half ind + 1 to n;
        List<Integer> sublist = a.subList(index + 1, n);
        Collections.reverse(sublist);
        return a;
    }

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
        List<Integer> ans = nextGreaterPermutation(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");

    }
}
