package leetcode;

import java.util.Arrays;

/**
 * @author Adam Wu
 * @date 2022-06-28 14:45:51
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int mid = (nums.length + 1) / 2;
        int[] little = new int[mid];
        System.arraycopy(nums, 0, little, 0, little.length);
        int[] large = new int[nums.length - mid];
        System.arraycopy(nums, mid, large, 0, large.length);

        // 反转
        rollback(little);
        rollback(large);

        int li = 0, la = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = little[li];
                li++;
            } else {
                nums[i] = large[la];
                la++;
            }
        }
    }

    void rollback(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        new Solution324().wiggleSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
