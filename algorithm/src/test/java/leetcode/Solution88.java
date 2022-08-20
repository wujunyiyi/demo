package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-06-01 14:52:00
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i =  m + n - 1; i >= 0; i--) {
            if (m > 0 && n > 0) {
                if (nums2[n - 1] > nums1[m - 1]) {
                    nums1[i] = nums2[--n];
                } else {
                    nums1[i] = nums1[--m];
                }
            } else if (m > 0 && n == 0) {
                break;
            } else if (m == 0 && n > 0) {
                nums1[i] = nums2[--n];
            }
        }
    }
}
