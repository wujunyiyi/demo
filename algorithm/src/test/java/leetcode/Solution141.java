package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-06-06 10:23:43
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next, slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
