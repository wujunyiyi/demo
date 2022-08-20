package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Adam Wu
 * @date 2022-06-27 11:47:11
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null || headB != null) {
            if (headA == headB) return headA;

            if (set.contains(headA)) return headA;

            if (set.contains(headB)) return headB;

            if (headA != null) {
                set.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                set.add(headB);
                headB = headB.next;
            }
        }

        return null;
    }
}
