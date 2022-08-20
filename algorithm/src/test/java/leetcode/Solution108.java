package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-09 15:59:38
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    TreeNode toBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = toBST(nums, l, mid - 1);
        root.right = toBST(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        new Solution108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
