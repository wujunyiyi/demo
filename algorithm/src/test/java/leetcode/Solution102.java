package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Adam
 * @create: 2022/05/17 15:39
 */
public class Solution102 {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            res.add(l);

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                l.add(poll.val);

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }

        }

        return res;
    }

    // 递归DFS思路
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        dfs(1, ans, root);
        return ans;
    }

    void dfs(int level, List<List<Integer>> ans, TreeNode root) {
        if (root == null) {
            return;
        }

        if (ans.size() < level) {
            ans.add(new ArrayList<>());
        }

        ans.get(level - 1).add(root.val);

        dfs(level + 1, ans, root.left);
        dfs(level + 1, ans, root.right);
    }
}
