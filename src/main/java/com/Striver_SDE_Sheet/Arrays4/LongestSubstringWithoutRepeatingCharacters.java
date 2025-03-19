package com.Striver_SDE_Sheet.Arrays4;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstringBrute(String s) {
        int n = s.length();
        if (n ==0 ) return 0;
        int cnt = 0;
        for (int i =0;i<n;i++){
            HashSet<Character> set = new HashSet<>();

            for (int j = i;j<n;j++){

                if (set.contains(s.charAt(j))){
                    cnt = Math.max(cnt,j-i);
                    break;
                }

                set.add(s.charAt(j));
            }
        }

        return cnt;
    }

    public int lengthOfLongestSubstringBetter(String s) {
        int n = s.length();

        if (n == 0) return 0;

        int cnt = 0;
        HashSet<Character> set = new HashSet<>();

        int l = 0;

        for (int r =0;r<n;r++){

            if (set.contains(s.charAt(r))){

                while (l < r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }

            set.add(s.charAt(r));
            cnt = Math.max(cnt,r -l + 1);
        }

        return cnt;
    }

    public int lengthOfLongestSubstringOptimal(String s) {
        int n = s.length();

        if (n == 0) return 0;

        int cnt = 0;

        int l = 0;
        int r = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (r < n){

            //to avod indexes on left side which is not being considered currently
            if (map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }

            map.put(s.charAt(r), r);

            cnt = Math.max(cnt,r - l +1);
            r++;
        }

        return cnt;
    }
}
