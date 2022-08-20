package leetcode;

/**
 * @author Adam Wu
 * @date 2022-07-04 13:29:16
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        return k;
    }
}
