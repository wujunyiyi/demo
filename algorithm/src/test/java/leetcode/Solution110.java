package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-10 17:23:30
 */
public class Solution110 {
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return ans;
    }

    int depth(TreeNode root) {
        if (root == null)
            return 0;

        int left = depth(root.left);
        int right = depth(root.right);

        if (Math.abs(left - right) >= 2) {
            ans = false;
        }

        return Math.max(left, right) + 1;
    }
}
