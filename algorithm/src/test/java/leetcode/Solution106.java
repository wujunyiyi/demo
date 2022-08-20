package leetcode;

import java.util.Arrays;

/**
 * @author Adam Wu
 * @date 2022-06-09 14:13:32
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }

        int val = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(val);

        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == val) {
                break;
            }
        }

        node.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        node.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, inorder.length - 1));

        return node;
    }
}
