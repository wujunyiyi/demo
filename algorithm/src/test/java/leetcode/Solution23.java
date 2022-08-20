package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Adam
 * @create: 2022/05/19 11:32
 */
public class Solution23 {
    // 归并
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode node : lists) {
            if (node != null)
                queue.offer(node);
        }

        ListNode node = null, head = null;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (node == null) {
                node = poll;
                head = poll;
            } else {
                node.next = poll;
                node = node.next;
            }

            if (poll.next != null) {
                queue.offer(poll.next);
            }

        }

        return head;
    }
}
