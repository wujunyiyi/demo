package leetcode;

/**
 * @author junyi.wu
 * @date 2022/9/2
 */
public class Solution687 {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;

    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int l = dfs(root.left), r = dfs(root.right), la = 0, ra = 0;
        if (root.left != null && root.val == root.left.val) {
            la = l + 1;
        }

        if (root.right != null && root.val == root.right.val) {
            ra = r + 1;
        }

        max = Math.max(max, la + ra);
        return Math.max(la, ra);
    }
}
