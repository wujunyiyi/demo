package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-10 14:20:23
 */
public class Solution109 {

    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, null);
    }

    TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode fast = head, slow = head;
        while (fast != tail && (fast = fast.next) != tail) {
            fast = fast.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }

    public static void main(String[] args) {
        Solution109 s = new Solution109();


        ListNode root = new ListNode(-10);
        ListNode tail = root;
        tail.next = new ListNode(-3);
        tail = tail.next;

        tail.next = new ListNode(0);
        tail = tail.next;

        tail.next = new ListNode(5);
        tail = tail.next;

        tail.next = new ListNode(9);
        tail = null;

        s.sortedListToBST(root);
    }
}
