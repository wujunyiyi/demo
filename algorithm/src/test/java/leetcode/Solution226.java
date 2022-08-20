package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-27 15:48:47
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
