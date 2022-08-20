package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Adam Wu
 * @date 2022-06-21 11:22:49
 */
public class Solution47 {
    // 回溯+排序+剪枝
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        List<Integer> source = new LinkedList<>();
        for (int num : nums) {
            source.add(num);
        }

        backtrack(ans, source, new ArrayList<>(), nums.length);
        return ans;
    }

    void backtrack(List<List<Integer>> ans, List<Integer> source, List<Integer> tmp, int len) {
        if (tmp.size() == len) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < source.size(); i++) {
            if (i > 0 && source.get(i) == source.get(i - 1)) {
                continue;
            }

            Integer val = source.get(i);
            source.remove(i);
            tmp.add(val);

            backtrack(ans, source, tmp, len);

            source.add(i, val);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution47().permuteUnique(new int[]{1, 1, 2});
    }
}
