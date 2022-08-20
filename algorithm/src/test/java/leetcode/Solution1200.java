package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Adam Wu
 * @date 2022-07-04 10:30:04
 */
public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int m = arr[i] - arr[i - 1];
            if (m < min) {
                min = m;
                ans.clear();
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (m == min) {
                ans.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return ans;
    }
}
