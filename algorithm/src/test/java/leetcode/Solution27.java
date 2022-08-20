package leetcode;

/**
 * @author Adam Wu
 * @data 2022-05-26 11:08:09
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] != val) {
                l++;
                continue;
            }

            if (nums[r] == val) {
                r--;
                continue;
            }

            nums[l] = nums[l] ^ nums[r];
            nums[r] = nums[r] ^ nums[l];
            nums[l] = nums[l] ^ nums[r];
        }

        return l;
    }

}
