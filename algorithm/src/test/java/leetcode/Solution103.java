package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @aurhor Adam Wu
 * @date 2022-06-07 14:24:55
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);

        boolean leftFlag = false;
        while (!queue.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            ans.add(res);

            TreeNode node;
            Deque<TreeNode> q2 = new LinkedList<>();
            while ((node = leftFlag ? queue.pollFirst() : queue.pollLast()) != null) {
                res.add(node.val);

                if (leftFlag) {
                    if (node.right != null) {
                        q2.offerLast(node.right);
                    }
                    if (node.left != null) {
                        q2.offerLast(node.left);
                    }
                } else {
                    if (node.left != null) {
                        q2.offerFirst(node.left);
                    }

                    if (node.right != null) {
                        q2.offerFirst(node.right);
                    }
                }
            }
            leftFlag = !leftFlag;
            queue = q2;
        }

        return ans;
    }
}
