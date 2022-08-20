package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Adam Wu
 * @date 2022-06-16 14:20:52
 */
public class Solution532 {
    // hash法
    public int findPairs1(int[] nums, int k) {
        Set<Integer> valid = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        for (int num : nums) {
            if (valid.contains(num - k)) {
                ans.add(num);
            }

            if (valid.contains(num + k)) {
                ans.add(num + k);
            }
            valid.add(num);
        }

        return ans.size();
    }

    // 双指针+排序, 结果超时了
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int val = nums[mid] - nums[i];
                if (val == k) {
                    ans++;
                    break;
                } else if (val > k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }

        return ans;
    }
}
