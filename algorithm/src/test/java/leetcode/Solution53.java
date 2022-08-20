package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-14 14:12:22
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0], pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }

        return max;
    }
}
