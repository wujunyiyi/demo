package leetcode;

import java.util.Arrays;

/**
 * @author Adam Wu
 * @date 2022-06-15 15:15:36
 */
public class Solution719 {
    // 排序+二分+双指针
    public int smallestDistancePair1(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);

        int len = nums.length, l = 0, r = nums[len - 1] - nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;

            int cnt = 0;
            for (int i = 0; i < len; i++) {
                int j = i + 1;
                while (j < len && nums[j] - nums[i] <= mid)
                    j++;
                cnt += j - i - 1;
            }

            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }

    // 暴力法, 容量越界。 效率上要优于上面
    public int smallestDistancePair(int[] nums, int k) {
        // 排序
        Arrays.sort(nums);

        int len = nums.length;
        int[] ans = new int[(len * (len - 1)) / 2];

        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                ans[index++] = nums[j] - nums[i];
            }
        }

        Arrays.sort(ans);
        return ans[k - 1];
    }
}
