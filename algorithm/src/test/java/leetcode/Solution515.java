package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Adam Wu
 * @date 2022-06-24 09:27:03
 */
public class Solution515 {
    // 广度优先
    public List<Integer> largestValues_1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if ((root == null)) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size(), max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            ans.add(max);
        }

        return ans;
    }

    // 深度优先
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, 0, root);
        return ans;
    }

    void dfs(List<Integer> ans, int depth, TreeNode root) {
        if (root == null) return;

        if (ans.size() <= depth) {
            ans.add(root.val);
        } else {
            ans.set(depth, Math.max(ans.get(depth), root.val));
        }

        dfs(ans, depth + 1, root.left);
        dfs(ans, depth + 1, root.right);
    }
}
