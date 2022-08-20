package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-27 11:07:10
 */
public class Solution538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }
}
