package leetcode;

/**
 * @author junyi.wu
 * @date 2022/9/2
 */
public class Solution64 {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int lat = grid.length, lon = grid[0].length;
        for (int i = 0; i < lat; i++) {
            for (int j = 0; j < lon; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }

        return grid[lat - 1][lon - 1];

    }
}
