package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-13 13:11:10
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return dfsBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfsBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }

        return dfsBST(root.left, min, root.val) && dfsBST(root.right, root.val, max);
    }
}
