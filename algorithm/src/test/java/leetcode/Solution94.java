package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yanzu wu
 * @date 2022-05-26 17:02:42
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursion(root, ans);
        return ans;
    }

    void recursion(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        recursion(root.left, ans);
        ans.add(root.val);
        recursion(root.right, ans);
    }
}
