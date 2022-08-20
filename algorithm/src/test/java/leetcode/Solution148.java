package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-22 13:57:14
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        return head == null ? null : sort(head, null);
    }

    // 归并排序
    ListNode sort(ListNode head, ListNode tail) {
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode mid = getMid(head, tail);
        ListNode l = sort(head, mid);
        ListNode r = sort(mid, tail);
        return merge(l, r);
    }

    ListNode merge(ListNode h1, ListNode h2) {
        ListNode head = new ListNode(-1), tmp = head;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                tmp.next = h1;
                h1 = h1.next;
            } else {
                tmp.next = h2;
                h2 = h2.next;
            }

            tmp = tmp.next;
        }

        if (h1 == null) {
            tmp.next = h2;
        }

        if (h2 == null) {
            tmp.next = h1;
        }

        return head.next;
    }

    // 快慢指针获取中间值
    ListNode getMid(ListNode head, ListNode tail) {
        ListNode fast = head, slow = head;

        while ((fast = fast.next) != tail) {
            slow = slow.next;
            if (fast.next != tail) {
                fast = fast.next;
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        new Solution148().sortList(node);
    }
}
