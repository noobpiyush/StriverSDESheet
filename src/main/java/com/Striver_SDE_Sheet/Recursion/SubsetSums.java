package com.Striver_SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {

    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;
        int n = arr.length;
        util(arr,n,0,0,ans);
        Collections.sort(ans);
        return ans;
    }

    public void util(int arr[], int n, int index, int sum,ArrayList<Integer> ans){

        if (index == n){
            ans.add(sum);
            return;
        }
        //take
        util(arr,n,index + 1, sum + arr[index],ans);

        //not take
        util(arr,n, index + 1, sum,ans);
    }

//              sum=0,i=0
//            /           \
//    sum=1,i=1           sum=0,i=1
//            /       \           /       \
//    sum=3,i=2     sum=1,i=2   sum=2,i=2  sum=0,i=2
//            /     \        /    \      /    \      /    \
//    sum=6,i=3 sum=3,i=3 sum=4,i=3 sum=1,i=3 sum=5,i=3 sum=2,i=3 sum=3,i=3 sum=0,i=3
}
