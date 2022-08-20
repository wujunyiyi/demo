package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-05-28 16:48:26
 */
public class Solution1021 {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int l = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            }

            if (l > 0) {
                sb.append(c);
            }

            if (c == ')') {
                l--;
            }
        }
        return sb.toString();
    }
}
