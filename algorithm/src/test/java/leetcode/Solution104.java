package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-06-08 09:46:40
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
