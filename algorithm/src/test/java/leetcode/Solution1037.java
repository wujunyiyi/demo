package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-06-08 09:33:58
 */
public class Solution1037 {

    public boolean isBoomerang(int[][] points) {
        int[] ab = new int[]{points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] ac = new int[]{points[2][0] - points[0][0], points[2][1] - points[0][1]};

        return ab[0] * ac[1] != ab[1] * ac[0];
    }
}
