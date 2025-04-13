package com.Striver_SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> list = new ArrayList<>();

        for(int i = 1;i<n;i++){
            fact = fact * i;
            list.add(fact);
        }

        //will break out of the loop
        // so add the last
        list.add(n);

        //0 based indexing so
        k = k-1;
        StringBuilder str = new StringBuilder();
        while (true){
            str.append(list.get(k/fact));
            list.remove(k/fact);

            if (list.isEmpty()) break;

            k = k % fact;

            fact = fact/ list.size();
        }

        return str.toString();
    }
}
