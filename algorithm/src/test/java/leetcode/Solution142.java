package leetcode;

import java.util.HashSet;

/**
 * @author Adam Wu
 * @date 2022-06-17 16:47:50
 */
public class Solution142 {
    // hash
    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode first = null;
        while (head != null) {
            if (set.contains(head)) {
                first = head;
                break;
            }

            set.add(head);
            head = head.next;
        }

        return first;
    }

    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        boolean meet = false;
        while (fast != null && fast.next != null) {
            if (meet) {
                if (fast == slow) {
                    return fast;
                }

                fast = fast.next;
                slow = slow.next;
            } else {
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    meet = true;
                    fast = head;
                }
            }

        }

        return null;
    }
}
