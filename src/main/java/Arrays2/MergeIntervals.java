package Arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] mergeBetter(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) continue;

            for (int j = i + 1; j < n; j++) {
                if (end >= intervals[j][0]) {
                    end = Math.max(end, intervals[j][1]);
                } else break;
            }

            ans.add(Arrays.asList(start, end));
        }

        int p = ans.size();
        int q = 2;

        int ansMatrix[][] = new int[p][q];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {

                ansMatrix[i][j] = ans.get(i).get(j);
            }
        }

        return ansMatrix;
    }

    public int[][] mergeOptimal(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();
        // if the current interval does not
        // lie in the last interval:
        for (int i = 0; i < n; i++) {
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < intervals[i][0]) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            // if the current interval
            // lies in the last interval:
            else {
              int greaterInterval = Math.max(ans.get(ans.size() -1 ).get(1), intervals[i][1]);
              ans.get(ans.size() -1).set(1,greaterInterval);
            }
        }

        int p = ans.size();
        int q = 2;

        int ansMatrix[][] = new int[p][q];

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {

                ansMatrix[i][j] = ans.get(i).get(j);
            }
        }

        return ansMatrix;
    }
}
