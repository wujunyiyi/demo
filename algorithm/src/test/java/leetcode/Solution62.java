package leetcode;

/**
 * @author junyi.wu
 * @date 2022/9/2
 */
public class Solution62 {

    // 杨辉三角 该路径= 左+上
    // 递归会超时
    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) return 1;
        return uniquePaths1(m - 1, n) + uniquePaths1(m, n - 1);
    }

    // 动态规划
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    ans[i][j] = 1;
                } else {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
                }
            }
        }

        return ans[m - 1][n - 1];
    }

}
