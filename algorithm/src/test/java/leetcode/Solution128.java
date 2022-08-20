package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Adam Wu
 * @date 2022-06-21 11:04:05
 */
public class Solution128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (Integer val : set) {
            if (!set.contains(val - 1)) {

                int len = 0;
                while (set.contains(val++)) {
                    len++;
                }

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution128().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}
