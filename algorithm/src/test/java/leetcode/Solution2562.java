package leetcode;

/**
 * @author: Adam
 * @create: 2022/05/16 09:46
 */
public class Solution2562 {
    // 遍历
    public TreeNode inorderSuccessor_1(TreeNode root, TreeNode p) {
        TreeNode node = root, parent = null;
        while (node != null) {
            if (p.val == node.val) {
                if (node.right == null) {
                    return parent;
                } else {
                    parent = node.right;

                    while (parent.left != null) {
                        parent = parent.left;
                    }
                    return parent;
                }
            } else if (p.val > node.val) {
                node = node.right;
            } else {
                parent = node;
                node = node.left;
            }
        }

        return parent;
    }

    // 遍历
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val <= p.val) inorderSuccessor(root.right, p);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode l1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        root.left = l1;
        root.right = r1;
        TreeNode node = new Solution2562().inorderSuccessor(root, l1);
        System.out.println();
    }
}
