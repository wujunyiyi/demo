package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-17 15:31:39
 */
public class Solution114 {

    public void flatten(TreeNode root) {
        preorder(root);
    }

    public TreeNode preorder(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode r = root.right;
        root.right = preorder(root.left);

        if (r != null) {
            TreeNode next = root;
            while (next.right != null) next = next.right;

            next.right = preorder(r);
        }

        root.left = null;
        return root;
    }
}
