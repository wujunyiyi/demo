package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-06-01 11:35:07
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            if (next != null && next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = next;
            }
        }

        return head;
    }
}
