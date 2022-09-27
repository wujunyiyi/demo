package leetcode;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * https://leetcode.cn/problems/check-permutation-lcci/
 *
 * @author junyi.wu
 * @date 2022/9/27
 */
public class Solution0102 {
    public boolean CheckPermutation(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 != l2) {
            return false;
        }
        int[] chars = new int[128];

        for (int i = 0; i < l1; i++) {
            chars[s1.charAt(i)]++;
        }

        for (int i = 0; i < l2; i++) {
            if (--chars[s2.charAt(i)] < 0) {
                return false;
            }

        }

        return true;
    }
}
