package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-22 09:54:23
 */
public class Solution543 {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max - 1;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        max = Math.max(max, l + r + 1);

        return Math.max(l + 1, r + 1);
    }
}
