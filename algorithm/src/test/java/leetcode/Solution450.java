package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-06-02 15:08:26
 */
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left != null && root.right == null) {
                return root.left;
            }

            if (root.left == null && root.right != null) {
                return root.right;
            }


            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }

            node.left = deleteNode(root.left, node.val);
            node.right = root.right;
            return node;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(6);
        TreeNode r3 = new TreeNode(7);
        TreeNode r4 = new TreeNode(8);
        TreeNode r5 = new TreeNode(9);

        root.right = r3;
        r3.left = r2;
        r3.right = r4;
        r2.left = r1;
        r4.right = r5;

        TreeNode node = new Solution450().deleteNode(root, 7);
        System.out.println();

    }
}
