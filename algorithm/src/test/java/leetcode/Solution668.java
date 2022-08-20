package leetcode;

import java.util.Arrays;

/**
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * <p>
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 * <p>
 * 例 1：
 * <p>
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 * <p>
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * <p>
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Adam
 * @create: 2022/05/18 10:44
 */
public class Solution668 {

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        int min = Math.min(m, n), max = Math.max(m, n);
        while (l < r) {
            int mid = l + (r - l) / 2;

            // count
            int count = 0;
            for (int i = 1; i <= min; i++) {
                count += Math.min(mid / i, max);
            }

            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    // 暴力解法
    public int findKthNumber1(int m, int n, int k) {
        int[] arr = new int[m * n];
        int index = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[index++] = i * j;
            }
        }

        Arrays.sort(arr);
        return arr[k - 1];
    }
}
