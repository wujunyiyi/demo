package leetcode;

/**
 * @author Adam Wu
 * @data 2022-05-26 13:08:04
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[l - 1]) {
                nums[l] = nums[i];
                l++;
            }
        }

        return l;
    }
}
