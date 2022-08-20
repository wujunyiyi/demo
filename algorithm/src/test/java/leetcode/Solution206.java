package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-16 10:09:52
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
