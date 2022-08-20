package leetcode;

import java.util.Arrays;

/**
 * @author Adam Wu
 * @date 2022-06-27 14:46:03
 */
public class Solution522 {
    public int findLUSlength(String[] strs) {
        int len = strs.length, ans = -1;
        for (int i = 0; i < len; i++) {
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                if (contain(strs[i], strs[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag) ans = Math.max(ans, strs[i].length());
        }

        return ans;
    }

    boolean contain(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }
        return i == s1.length();
    }

    public static void main(String[] args) {
        int i = new Solution522().findLUSlength(new String[]{"aabbcc", "aabbcc", "cb"});
        System.out.println(i);
    }
}
