package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Adam Wu
 * @date 2022-06-23 14:16:57
 */
public class Solution90 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    // 回溯问题。 78题的扩展 剪枝过程
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        dfs(true, 0, nums);
        return ans;
    }

    void dfs(boolean preFlag, int index, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }


        int val = nums[index];
        tmp.add(val);
        dfs(true, index + 1, nums);
        tmp.remove(tmp.size() - 1);
        // 剪枝
        if (preFlag && index > 0 && nums[index] == nums[index - 1]) {
            return;
        }
        dfs(false, index + 1, nums);
    }

    public static void main(String[] args) {
        new Solution90().subsetsWithDup(new int[]{1, 2, 2, 2});
    }
}
