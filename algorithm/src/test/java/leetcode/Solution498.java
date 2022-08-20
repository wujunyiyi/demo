package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-14 13:13:00
 */
public class Solution498 {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];

        int index = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                int lon = Math.min(i, m - 1), lat = i < m ? 0 : i - m + 1;
                while (lon >= 0 && lat < n) {
                    ans[index++] = mat[lon][lat];
                    lon--;
                    lat++;
                }
            } else {
                int lon = i < n ? 0 : i - n + 1, lat = Math.min(i, n - 1);
                while (lat >= 0 && lon < m) {
                    ans[index++] = mat[lon][lat];
                    lon++;
                    lat--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new Solution498().findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(ans);
    }
}
