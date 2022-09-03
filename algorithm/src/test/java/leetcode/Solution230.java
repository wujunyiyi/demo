package leetcode;

/**
 * @author junyi.wu
 * @date 2022/9/3
 */
public class Solution230 {
    Integer ans;
    int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root) {
        if(ans != null) return;

        if (root.left != null) dfs(root.left);
        if (k-- == 1) ans = root.val;
        if (root.right != null) dfs(root.right);

    }
}
