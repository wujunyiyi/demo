package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-27 11:31:58
 */
public class Solution1038 {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);

        return root;
    }
}
