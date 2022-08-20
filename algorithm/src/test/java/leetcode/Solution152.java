package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-23 10:43:45
 */
public class Solution152 {

    // 动态规划
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i], ma = max, mi = min;
            max = Math.max(num, Math.max(num * ma, num * mi));
            min = Math.min(num, Math.min(num * mi, num * ma));

            ans = Math.max(ans, max);
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution152().maxProduct(new int[]{-4, -3, -2});
    }
}
