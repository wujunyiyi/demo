package leetcode;

/**
 * @author Adam Wu
 * @data 2022-05-25 17:32:03
 */
public class Solution467 {
    public int findSubstringInWraproundString(String p) {
        int[] ans = new int[26];
        ans[p.charAt(0) - 'a'] = 1;

        int c = 1;
        for (int i = 1; i < p.length(); i++) {
            if (((p.charAt(i) - p.charAt(i - 1) + 26) % 26) == 1) {
                c++;
            } else {
                c = 1;
            }

            ans[p.charAt(i) - 'a'] = Math.max(ans[p.charAt(i) - 'a'], c);
        }

        int sum = 0;
        for (int an : ans) {
            sum += an;
        }
        return sum;
    }
}
