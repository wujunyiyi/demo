package leetcode;

/**
 * @author Adam Wu
 * @date 2022-07-06 09:57:26
 */
public class Solution124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;

        int l = Math.max(dfs(root.left), 0);
        int r = Math.max(dfs(root.right), 0);
        max = Math.max(max, root.val + l + r);

        return root.val + Math.max(l, r);
    }
}
