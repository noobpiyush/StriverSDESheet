package com.Striver_SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void util(String s, int n, int index, List<String> ds, List<List<String>> ans) {
        //base case
        if (index == n){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i  = index;i<n;i++){
            if(isPalindrome(s,index,i)){
                ds.add(s.substring(index,i+1));
                util(s,n,i+1,ds,ans);
                ds.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        List<String> ds = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        util(s,n,0,ds,ans);

        return ans;
    }

    public static boolean isPalindrome(String s, int start, int end){

        while (start <= end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
