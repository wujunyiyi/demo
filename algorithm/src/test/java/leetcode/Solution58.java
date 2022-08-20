package leetcode;

/**
 * @aurhor Adam Wu
 * @date 2022-06-01 11:47:35
 */
public class Solution58 {

    public int lengthOfLastWord(String s) {
        int start = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ' && start == 0)
                continue;

            if (c == ' ')
                break;

            start++;
        }

        return start;
    }

    public static void main(String[] args) {
        new Solution58().lengthOfLastWord(" ");
    }
}
