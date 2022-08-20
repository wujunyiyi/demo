package leetcode;

/**
 * @author Adam Wu
 * @date 2022-07-06 09:36:29
 */
public class Solution70 {
    public int climbStairs(int n) {
        int s1 = 0, s2 = 1, ans = s2;
        for (int i = 2; i <= n; i++) {
            s1 = s2;
            s2 = ans;
            ans = s1 + s2;
        }

        return ans;
    }
}
