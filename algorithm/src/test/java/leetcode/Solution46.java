package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Adam Wu
 * @data 2022-05-26 14:29:50
 */
public class Solution46 {
    // 回溯
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> source = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            source.add(nums[i]);
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
            int val = source.get(i);
            tmp.add(val);
            source.remove(i);
            backtrack(ans, source, tmp, len);

            tmp.remove(tmp.size() - 1);
            source.add(i, val);
        }
    }
}
