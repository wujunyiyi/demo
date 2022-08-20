package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-06-07 14:11:36
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    boolean symmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null) {
            return false;
        }

        return l.val == r.val && symmetric(l.left, r.right) && symmetric(l.right, r.left);
    }
}
