package com.Striver_SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> ds = new ArrayList<>();

        util(candidates,0,target,candidates.length,ans, ds);

        return ans;
    }

    public void util(int candidates[] ,int index, int target, int n,List<List<Integer>> ans, List<Integer> ds){

        //base case

        if (index == n){

            if (target == 0){
                ans.add(new ArrayList<>(ds));
                return;
            }
            return;
        }

        //take case & remain at the same index

        if (target >= candidates[index]){

            //add the ele to the ds
            ds.add(candidates[index]);

            //rec call & remain at the same index
            util(candidates,index, target - candidates[index], n,ans,ds);

            //back track
            ds.removeLast();
        }

        //not take case
        util(candidates,index+1,target,n,ans,ds);
    }
}
