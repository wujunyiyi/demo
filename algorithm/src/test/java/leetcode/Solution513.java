package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-22 09:29:57
 */
public class Solution513 {
    private int maxDepth, ans;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (depth > maxDepth) {
            maxDepth = depth;
            ans = root.val;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
