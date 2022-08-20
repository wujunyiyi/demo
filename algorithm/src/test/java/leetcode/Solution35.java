package leetcode;

/**
 * @author Adam Wu
 * @data 2022-05-26 10:15:40
 */
public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
