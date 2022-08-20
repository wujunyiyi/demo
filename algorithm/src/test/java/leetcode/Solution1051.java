package leetcode;

import java.util.Arrays;

/**
 * @author Adam Wu
 * @date 2022-06-13 09:48:13
 */
public class Solution1051 {

    public int heightChecker(int[] heights) {
        int[] n = new int[heights.length];

        System.arraycopy(heights, 0, n, 0, heights.length);
        Arrays.sort(n);

        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (n[i] != heights[i]) {
                ans++;
            }
        }

        return ans;
    }
}
