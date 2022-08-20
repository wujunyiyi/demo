package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Adam Wu
 * @date 2022-06-22 10:54:07
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();
        backtrack(ans, tmp, 0, nums);
        return ans;
    }

    void backtrack(List<List<Integer>> ans, List<Integer> tmp, int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[index]);
        backtrack(ans, tmp, index + 1, nums);
        tmp.remove(tmp.size() - 1);
        backtrack(ans, tmp, index + 1, nums);
    }

    public static void main(String[] args) {
        new Solution78().subsets(new int[]{1, 2, 3});
    }
}
