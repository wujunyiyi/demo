package leetcode;

/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/univalued-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Adam Wu
 * @data 2022-05-24 09:34:38
 */
public class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }


        boolean flag = true;
        TreeNode left = root.left;
        if (left != null) {
            if (root.val != left.val || !isUnivalTree(left)) {
                flag = false;
            }
        }

        TreeNode right = root.right;
        if (right != null) {
            if (root.val != right.val || !isUnivalTree(right)) {
                flag = false;
            }
        }

        return flag;
    }
}
