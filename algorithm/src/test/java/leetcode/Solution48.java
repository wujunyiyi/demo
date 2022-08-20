package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-20 14:17:19
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j] ^ matrix[n - i - 1][j];
                matrix[i][j] = matrix[i][j] ^ matrix[n - i - 1][j];
            }
        }

        // 对角线
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
    }
}
