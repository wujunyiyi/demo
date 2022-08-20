package leetcode;

/**
 * @author Adam Wu
 * @date 2022-06-10 17:04:17
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if ((len1 + len2) % 2 == 0) {
            // 偶数
            double l = kth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len2 + len1) / 2);
            double r = kth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len2 + len1) / 2 + 1);
            return (l + r) * 0.5;
        }

        // 奇数
        return kth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len2 + len1 + 1) / 2);
    }

    double kth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        // nums1 长度小于nums2
        if (len1 > len2) {
            return kth(nums2, l2, r2, nums1, l1, r1, k);
        }

        if (len1 == 0) {
            return nums2[l2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }

        int mid = k / 2;
        int n1 = Math.min(len1, mid) + l1 - 1;
        int n2 = Math.min(len2, mid) + l2 - 1;
        if (nums1[n1] <= nums2[n2]) {
            return kth(nums1, n1 + 1, r1, nums2, l2, r2, k - Math.min(len1, mid));
        }

        return kth(nums1, l1, r1, nums2, n2 + 1, r2, k - Math.min(len2, mid));
    }

    public static void main(String[] args) {
        double a = new Solution4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4});
        System.out.println(a);
    }
}
