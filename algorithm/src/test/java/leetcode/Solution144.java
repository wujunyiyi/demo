package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @aurhor Adam Wu
 * @date 2022-06-02 17:12:42
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursion(root, ans);
        return ans;
    }

    void recursion(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        recursion(root.left, ans);
        recursion(root.right, ans);
    }
}
